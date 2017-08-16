import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//Zachary Bessette

/**
 * A coocurrence matrix for a predefined list of keywords.  A coocurrence
 * matrix records how often each keyword appears in the same context
 * as each other keyword.  If keyword x appears in m contexts and keyword y
 * appears in n of those m contexts then the entry in the coocurrence matrix
 * at position (x, y) would be n/m.
 *
 * @author Jim Glenn
 * @version 0.1 2017-03-22
 */

public class MyCooccurrenceMatrix implements CooccurrenceMatrix
{

    private List<String> words;
    //private HashMap<String,ArrayList<Double>> occur;
    private HashMap<String,HashMap<String, Double>> occur;
    private int size;
    private HashMap<String, Double> denominators;

    //constructor
    public MyCooccurrenceMatrix(List<String> w){
        words = w;
        size=w.size();
        denominators = new HashMap<String, Double>(size);
        //occur = new HashMap<String, ArrayList<Double>>(size);
        occur = new HashMap<String, HashMap<String, Double>>(size);
        for(int i=0;i<size; i++){
            denominators.put(words.get(i), 0.0);
            //occur.put(words.get(i), new ArrayList<Double>(size));
            occur.put(words.get(i), new HashMap<String, Double>(size));
            for(int j=0; j<size; j++){
                //occur.get(words.get(i)).add(0.0);
                occur.get(words.get(i)).put(words.get(j), 0.0);
            }
        }

        // for(String word:words){
        //     System.out.println(word+": "+ occur.get(word));
        // }

        //error checking
        // for (String word : words){
        //     System.out.println(word + ": " + Arrays.toString(getVector(word)));
        // }


    }



    /**
     * Updates this cooccurrence matrix for the given context.
     * After this call, each entry in this cooccurrence matrix will reflect
     * the cooccurrence of each keyword in the context previously passed
     * to update and this one.
     *
     * @param context a list of words
     */
    public void update(List<String> context){
        HashSet<String> appear= new HashSet<String>();
        for(int i=0; i<context.size(); i++){
            appear.add(context.get(i));
        }
        Iterator<String> iter = appear.iterator();
        Iterator<String> iter2 = appear.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(denominators.containsKey(s)){
                denominators.put(s, denominators.get(s)+1.0);
                while(iter2.hasNext()){
                    String s2 = iter2.next();
                    if(denominators.containsKey(s2)){
                        //occur.get(s).set(words.indexOf(s2), occur.get(s).get(words.indexOf(s2))+1.0);
                        occur.get(s).put(s2, occur.get(s).get(s2)+1.0);                      
                    }
                }
                
            }

            iter2=appear.iterator();
        }



    }

    /**
     * Returns the coocurrence vector for the given keyword.  For each
     * keyword the returned array contains the proportion of contexts
     * the given word appeared in that also contained that other keyword.
     * The frequencies in the array are given in the same order as the
     * keywords in the list originally used to construct this matrix and
     * the entry for the given word is 1.0.
     *
     * @param keyword a word in the list originally passed to the constructor
     * @return an array containing the normalized frequency for the
     * given keyword and every other keyword
     * @throws IllegalArgumentException if keyword was not in the list passed
     * to the constructor
     */
    public double[] getVector(String keyword){
        if(!denominators.containsKey(keyword)){
            throw new IllegalArgumentException("Keyword not in specified list");
        }
        else{
            double[] vector = new double[size];
            for(int i=0; i<size;i++){
                //vector[i] = (occur.get(keyword).get(i))/denominators.get(keyword);
                vector[i] = (occur.get(keyword).get(words.get(i)))/denominators.get(keyword);
            }
            return vector;
        }

    } 
}
