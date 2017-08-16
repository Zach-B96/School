import input_data
import cifar_toolsJER as cifar_tools
import tensorflow as tf
import time

# change to 'cifar-10-batches-py'  on a local  machine after installing cifar

names, data, labels = \
    cifar_tools.read_data('./cifar-10-batches-py')

def makeOneHot(origs):
    answer = []
    for x in origs:
        one = (x)*[0.0]+[1.0]+(10-x-1)*[0.0]
        answer.append(one)
    return answer

labels = makeOneHot(labels)

class dataset(object):
    def __init__(self,data,labels):
        self.batchPoint = 0
        self.data = data
        self.labels = labels
        self.num_examples = len(self.data)
    def nextBatch(self,i):
        if self.batchPoint == len(self.data):
            self.batchPoint = 0
        self.batchPoint = self.batchPoint+i
        return self.data[self.batchPoint-i:self.batchPoint],self.labels[self.batchPoint-i:self.batchPoint]


trainingSet = dataset(data[0:35000],labels[0:35000])
validationSet = dataset(data[35001:40000],labels[35001:40000])
testingSet = dataset(data[40001:49999],labels[40001:49999])


# Parameters
learning_rate = 0.01
training_epochs = 1000
batch_size = 100
display_step = 1
momentum = 0.5

"""
The function tf.get_variable() is used to get or create a variable instead of a direct call to tf.Variable. It uses an initializer instead of passing the value directly, as in tf.Variable. An initializer is a function that takes the shape and provides a tensor with that shape. Here are some initializers available in TensorFlow:
    tf.constant_initializer(value) initializes everything to the provided value,
    tf.random_uniform_initializer(a, b) initializes uniformly from [a, b],
    tf.random_normal_initializer(mean, stddev) initializes from the normal distribution with the given mean and standard deviation.
"""

def conv2d(input, weight_shape, bias_shape, strideShape = [1,1,1,1]):
    incoming = weight_shape[0] * weight_shape[1] * weight_shape[2]
    weight_init = tf.random_normal_initializer(stddev=(2.0/incoming)**0.5)
    W = tf.get_variable("W", weight_shape, initializer=weight_init)
    bias_init = tf.constant_initializer(value=0)
    b = tf.get_variable("b", bias_shape, initializer=bias_init)
    return tf.nn.relu(tf.nn.bias_add(tf.nn.conv2d(input, W, strides=strideShape, padding='SAME'), b))

"""
tf.nn.max_pool(value, ksize, strides, padding, data_format='NHWC', name=None)
Performs the max pooling on the input.
Args:
    value: A 4-D Tensor with shape [batch, height, width, channels] and type tf.float32.
    ksize: A list of ints that has length >= 4. The size of the window for each dimension of the input tensor.
    strides: A list of ints that has length >= 4. The stride of the sliding window for each dimension of the input tensor.
    padding: A string, either 'VALID' or 'SAME'. The padding algorithm.
    data_format: A string. 'NHWC' and 'NCHW' are supported.
    name: Optional name for the operation.
Returns:
A Tensor with type tf.float32. The max pooled output tensor.
"""


def max_pool(input, p=2, k=2):
    return tf.nn.max_pool(input, ksize=[1, p, p, 1], strides=[1, k, k, 1], padding='SAME')

def layer(input, weight_shape, bias_shape):
    weight_init = tf.random_normal_initializer(stddev=(2.0/weight_shape[0])**0.5)
    bias_init = tf.constant_initializer(value=0)
    W = tf.get_variable("W", weight_shape,
                        initializer=weight_init)
    b = tf.get_variable("b", bias_shape,
                        initializer=bias_init)
    return tf.nn.relu(tf.matmul(input, W) + b)

"""
tf.nn.dropout
tf.nn.dropout
dropout(
    x,
    keep_prob,
    noise_shape=None,
    seed=None,
    name=None
)
Computes dropout.
With probability keep_prob, outputs the input element scaled up by 1 / keep_prob, otherwise outputs 0. The scaling is so that the expected sum is unchanged.
"""

def inference(x, keep_prob):

    x = tf.reshape(x, shape=[-1, 24, 24, 1])
    with tf.variable_scope("conv_1"):
        conv_1 = conv2d(x, [5, 5, 1, 32], [32])
        pool_1 = max_pool(conv_1)

    with tf.variable_scope("conv_2"):
        conv_2 = conv2d(pool_1, [5, 5, 32, 64], [64])
        pool_2 = max_pool(conv_2)

    with tf.variable_scope("fc"):
        pool_2_flat = tf.reshape(pool_2, [-1, 6 * 6 * 64])
        fc_1 = layer(pool_2_flat, [6*6*64, 1024], [1024])

        # apply dropout
        fc_1_drop = tf.nn.dropout(fc_1, keep_prob)

    with tf.variable_scope("output"):
        output = layer(fc_1_drop, [1024, 10], [10])

    return output

"""
tf.nn.softmax_cross_entropy_with_logits
Computes softmax cross entropy between logits and labels.
"""

def loss(output, y):
    xentropy = tf.nn.softmax_cross_entropy_with_logits(logits = output, labels = y)
    loss = tf.reduce_mean(xentropy)
    return loss

def training(cost, global_step):
    tf.summary.scalar("cost", cost)
    optimizer = tf.train.MomentumOptimizer(learning_rate, momentum) #AdamOptimizer(learning_rate)
    train_op = optimizer.minimize(cost, global_step=global_step)
    return train_op


def evaluate(output, y):
    correct_prediction = tf.equal(tf.argmax(output, 1), tf.argmax(y, 1))
    accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    tf.summary.scalar("validation error", (1.0 - accuracy))
    return accuracy

if __name__ == '__main__':


    with tf.Graph().as_default():

        with tf.variable_scope("cifar_conv_model"):

            #tf.set_random_seed(4532)
            tf.set_random_seed(3210)

            x = tf.placeholder("float", [None, 576]) # cifar data image of shape 24*24=576
            y = tf.placeholder("float", [None, 10]) # 10 classes
            keep_prob = tf.placeholder(tf.float32) # dropout probability

            output = inference(x, keep_prob)

            cost = loss(output, y)

            global_step = tf.Variable(0, name='global_step', trainable=False)

            train_op = training(cost, global_step)

            eval_op = evaluate(output, y)

            summary_op = tf.summary.merge_all()

            saver = tf.train.Saver()

            sess = tf.Session()

            summary_writer = tf.summary.FileWriter("conv_cifar_logs/",
                                                   sess.graph)

            init_op = tf.global_variables_initializer()

            sess.run(init_op)



            # Training cycle
            for epoch in range(training_epochs):

                avg_cost = 0.
                total_batch = int(trainingSet.num_examples/batch_size)
                # Loop over all batches
                for i in range(total_batch):
                    minibatch_x, minibatch_y = trainingSet.nextBatch(batch_size)
                    # Fit training using batch data
                    sess.run(train_op, feed_dict={x: minibatch_x, y: minibatch_y, keep_prob: 0.5})
                    # Compute average loss
                    avg_cost += sess.run(cost, feed_dict={x: minibatch_x, y: minibatch_y, keep_prob: 0.5})/total_batch
                    # Display logs per epoch step
                if epoch % display_step == 0:
                    print("Epoch:", epoch+1, "cost =", avg_cost)

                    accuracy = sess.run(eval_op, feed_dict={x: validationSet.data, y: validationSet.labels, keep_prob: 1})

                    print("Validation Accuracy:", accuracy)

                    summary_str = sess.run(summary_op, feed_dict={x: minibatch_x, y: minibatch_y, keep_prob: 0.5})
                    summary_writer.add_summary(summary_str, sess.run(global_step))

                    saver.save(sess, "conv_cifar_logs/model-checkpoint", global_step=global_step)

                accuracy = sess.run(eval_op, feed_dict={x: testingSet.data, y: testingSet.labels, keep_prob: 1})

                print("Test Accuracy:", accuracy)

            print("Optimization Finished!")
            