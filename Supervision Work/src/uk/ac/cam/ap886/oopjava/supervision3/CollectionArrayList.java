package uk.ac.cam.ap886.oopjava.supervision3;

import java.util.AbstractList;
import java.util.List;

public class CollectionArrayList<E> extends AbstractList<E> implements List<E> {

	protected E[] list;
	protected int last;
	private final int INITIAL_ARRAY_LENGTH = 50;
	
	@SuppressWarnings("unchecked")	//It is checked we know this going to be an E array
	public CollectionArrayList (){
		list = (E[]) new Object[INITIAL_ARRAY_LENGTH];
		last = 0;
	}
	
	@SuppressWarnings("unchecked")
	public CollectionArrayList (int length){
		list = (E[]) new Object[length];
		last = 0;
	}
	
	@Override
	public E get(int index) {
		if(index <last && index>=0){
			return list [index];
		}
		else{
			throw new IndexOutOfBoundsException
			("Index "+new Integer(index).toString()+" Not present");
		}
		//To be Collections Compliant we need to throw specific exceptions
		//otherwise there's no sense in implementing the List interface. 
	}

	@Override
	public E remove(int index) {
		if(last ==0){
			throw new IndexOutOfBoundsException("Tried to remove from empty List");
		}
		E removedElement = get(index); 	
		//Avoids duplication of catching, also               
		//Helps if we want to change the numbering convention
		//To or from zero based;      
		for(int i=index;i<last;i++){
			if(i + 1 >= last){//preLast element. Just need to shorten the array
				last--;
				break;
			}else{			//Otherwise need to shift everything left 
				list[i] = list[i+1];
			}
		}
		return removedElement;		
	}

	@SuppressWarnings("unchecked")//Same as in the Constructor
	@Override
	public E set(int index, E newValue) {
		E cache = null;
		if(index <0){
			throw new IndexOutOfBoundsException
			(new Integer(index).toString()+ " is not a valid positive integer");
		}else if(index >last+1){
			throw new IndexOutOfBoundsException
			(new Integer(index).toString()+ " Exceeeded "+ new Integer(last+1).toString());
		}else {
			cache = get(index);
			if(index <=last){
				list[index] = newValue;
			}else{	//Setting exactly last element
				if(index <=list.length ){
					last = index;
					list[index] = newValue;
				}else{//Need to resize the array
					E[] oldList = list;
					list = (E[]) new Object[oldList.length + INITIAL_ARRAY_LENGTH];
					for(int i=0;i<oldList.length;i++){
						list[i] = oldList[i];
					}
					last = index;
					list[index]= newValue;
				}
			}
		}
		return cache;
	}
	@Override
	public boolean add(E newElement){
		set(last+1, newElement);
		return true;
		
	}

	@Override
	public int size() {
		return last;
	}

}
