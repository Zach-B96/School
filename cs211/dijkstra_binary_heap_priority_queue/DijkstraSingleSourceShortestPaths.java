simport java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

// Zachary Bessette

/**
 * The result of running single-source shortest paths.
 *
 * @param E the type of the labels on the vertices
 * @version 0.1 2017-04-12
 */

public class DijkstraSingleSourceShortestPaths<E> implements SingleSourceShortestPaths<E>
{

    private E source;

    private Map<E, Map<E, Double>> edges;

    private Map<E, Double> distances;

    private Map<E, E> pred;

    private PriorityQueue priority;

    private Set<E> visited;

    public DijkstraSingleSourceShortestPaths(Map<E, Map<E, Double>> e, E s){
        edges = e;
        source = s;
        priority = new BinaryHeapPriorityQueue();
        visited = new HashSet();
        pred = new HashMap<E, E>();
        distances = new HashMap<E, Double>();
        priority.add(source, 0.0);
        pred.put(source, null);
        distances.put(source, 0.0);
        while(priority.size()>0){
            Double t = priority.peekMin();
            E u = (E)priority.extractMin();
            visited.add(u);
            HashMap<E, Double> neighbors = (HashMap<E, Double>)edges.get(u);
            Set<E> neighborsSet = neighbors.keySet();
            Iterator<E> iter = neighborsSet.iterator();
            while(iter.hasNext()){
                E v =iter.next();
                if(visited.contains(v)){
                    continue;
                }
                else if(!priority.contains(v)){
                    priority.add(v, (Double)t+neighbors.get(v));
                    pred.put(v, u);
                    distances.put(v, (Double)t+neighbors.get(v));
                }
                else if(priority.contains(v) && priority.getPriority(v) > ((Double)t+neighbors.get(v))){
                    priority.decreasePriority(v, (Double)t + neighbors.get(v));
                    pred.put(v, u);
                    distances.put(v, (Double)t+neighbors.get(v));
                }
            }
        }
    }



// make a priority queue where the items are the vertices and the priorities are the distances
// make a map from cities to predecessor cities (the previous city on the shortest path from the source)
// make a map from cities to distances
// add the source to the queue with priority 0
// while the queue is not empty
    // get the vertex u with the minimum priority and that minimum priority t from the queue
    // for each neighbor vertex v of u
        // if v has already been taken off the queue then do nothing
        // else if v is not in the queue, add it with priority p = t + w(u, v)
        // else if v is in the queue and its current priority is > p, update its priority
        // else do nothing









    /**
     * Returns the list of vertices on a shortest path from the source
     * to the given destination.  If there is no path then the return
     * value should be null.
     *
     * @param dest the label of a vertex; not null
     * @return a list containing the vertices on a shortest path from
     * the source to the given destination, or null of there is no path
     */
    public List<E> getPath(E dest){

        if(!pred.containsKey(dest)){
            return null;
        }

        List<E> path = new ArrayList<E>();
        E before = pred.get(dest);
        path.add(0, dest);
        while(!before.equals(source)){
            path.add(0, before);
            before = pred.get(before);
        }
        path.add(0, source);

        return path;
    }

    /**
     * Returns the total cost of a shortest path from the source
     * to the given destination.
     *
     * @param dest the label of a vertex to which there is a path from
     * the source; not null
     * @return the total cost of a shortest path from the source to the
     * given destination
     */
    public double getDistance(E dest){
        return distances.get(dest);
    }
}
