import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Math;
/*
Zachary Bessette
Programming Project 1
3-24-2017
*/

public class HybridArraySet211<E extends Comparable<? super E>> implements Set211<E>{
	
	private ArrayList<E> sorted; // sorted array

	private ArrayList<E> unsorted;//unsorted array

	private int sortedCount;//size of sorted array

	private int unsortedCount;//size of unsorted array

	private int opCount;


	//constructor
	public HybridArraySet211(){
		sorted = new ArrayList<E>();
		unsorted = new ArrayList<E>();
		sortedCount=0;
		unsortedCount=0;
	}


 	/**
     * Adds the given item to this set.
     *
     * @param toAdd the item to add
     */
    public void add(E toAdd){
    	if(!contains(toAdd)){
			if(unsortedCount>Math.sqrt(sortedCount))
				rearrange();
			unsorted.add(toAdd);
			opCount+=1;
			unsortedCount++;
    	}
    }

    /**
     * Determines if this set contains the given item.
     *
     * @param item the item to check for
     * @return true if and only it that item is in this set
     */
    public boolean contains(E item){
		if(Collections.binarySearch(sorted, item)>=0){
			opCount+=Math.log(sortedCount);
			return true;
		}
		if(unsorted.contains(item)){
			opCount+=unsortedCount;
			return true;
		}
		return false;
    }

    /**
     * Removes the given item from this set.  There is no effect if the
     * item is not in this set.
     *
     * @param item the item to remove
     */
    public void remove(E item){
    	int index = Collections.binarySearch(sorted, item);
    	opCount+=Math.log(sortedCount);
    	if(index>=0){
    		sorted.remove(index);
    		opCount+=1;
    	}
		else{
			unsorted.remove(item);
			opCount+=unsortedCount;
		}
    }

    /**
     * Returns the number of unique items in this set.
     *
     * @return the number of items in this set
     */
    public int size(){
		return sortedCount+unsortedCount;
    }


    /**
     * Sorts the unsorted array
     * Merges the two arrays
     * Empties the unsorted array
     */
    private void rearrange(){
		Collections.sort(unsorted);
		opCount+=unsortedCount;

		ArrayList<E> merged = new ArrayList<E>();

   		Iterator<E> sort = sorted.iterator();
    	Iterator<E> unsort = unsorted.iterator();
    	E addSort = null;
    	E addUnsort = null;

    	if(sort.hasNext()){
    		opCount+=sortedCount;
    		addSort=sort.next();
    	}
    	if(unsort.hasNext()){
    		opCount+=unsortedCount;
    		addUnsort = unsort.next();
    	}

		while(addSort!=null && addUnsort!=null){
			int compare = addSort.compareTo(addUnsort);
			if(compare <= 0){
				merged.add(addSort);
				opCount+=1;
				if(sort.hasNext()){
					opCount+=Math.log(sortedCount);
    				addSort = sort.next();
				}
    			else{
    				addSort = null;
    			}
			}
			else{
				merged.add(addUnsort);
			    if(unsort.hasNext()){
			    	opCount+=unsortedCount;
    				addUnsort = unsort.next();
			    }
    			else 
    				addUnsort = null;
    		}
		}
		while(addSort!=null){
			merged.add(addSort);
			opCount+=1;
			if(sort.hasNext()){
				opCount+=Math.log(sortedCount);
    			addSort = sort.next();
			}
   			else{
   				addSort = null;
   			}
   		}
   		while(addUnsort!=null){
			merged.add(addUnsort);
			opCount+=1;
		    if(unsort.hasNext()){
		    	opCount+=Math.log(sortedCount);
    			addUnsort = unsort.next();
		    }
   			else{
   				addUnsort = null;
   			}
   		}
		sorted = merged;
		unsorted.clear();
		opCount+=unsortedCount;
		sortedCount = sortedCount+unsortedCount;
		unsortedCount=0;
			
    }


    public String toString(){
    	return "Sorted Array: "+sorted.toString()+System.lineSeparator()+"Unsorted Array: "+unsorted.toString();
    }

    // public int getOpCount(){
    // 	return opCount;
    // }
    //I nulled this because it is not implemented by your Set211 interface by default

}
