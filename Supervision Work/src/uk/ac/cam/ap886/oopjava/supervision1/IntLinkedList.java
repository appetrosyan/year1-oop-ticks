package uk.ac.cam.ap886.oopjava.supervision1;

public class IntLinkedList {	//Relevant to question 7
	private int head;
	private IntLinkedList tail;
	private int depth;
	
	public int getHead(){
		return head;
	}
	public int getDepth() {
		return depth;
	}
	
	public IntLinkedList getTail(){
		return this.tail;
	}
	
	public IntLinkedList (int value){

		head=value; tail=null;	depth=1;							//default 
	}
	
	//Typical Usage 
	/*
	 * IntLinkedList a = new IntLinkedList (initialValue);
	 * a = a.cons (secondValue);
	 * a = a.cons (thirdValue);
	 * 
	 */
	
	public IntLinkedList cons (int value){
		IntLinkedList newElement=new IntLinkedList(value);	//Allocate space on heap
		newElement.tail=this;								//tail = parent list. 
		newElement.depth = this.depth + 1;					//Increase depth by one
		return newElement;									//return reference. 
	}
	
	
	public IntLinkedList getNthLink(int N){
		IntLinkedList NthElement=this;					//Get a handle on parent
		while (N>1){									//If we have an invalid argument just return parent. 
			NthElement= NthElement.tail==null?NthElement:NthElement.tail;		//Deepen one level
			N--;								//Decrease iterator
		}										//If value is too large for the length of list
												//Will just return last element.
		return NthElement;						//return Reference to the element.
	}
	
	public IntLinkedList append (IntLinkedList b){
		this.getNthLink(this.depth).tail = b;	//Getting to end of first list and changing the null pointer to
		this.depth+=b.depth;					//b. DEpths need to be added.  
		return this;
	}
	
	//This implementation is mutable and thus append is not so computationally difficult as ML's, this means that
	//side effects are possible. If we remove append and keep this class as it is, it maps 1:1 to ML lists with 
	//the same properties including the fact that cycles are impossible to create. 
	//
	//Cycles are possible with append because we could just append the list to itself and create a cyclic list. 
	
	
	//Cycle Detection
	public static boolean cycled (IntLinkedList a){
		return !(a.getNthLink(a.depth).tail==null);	//If it's cycled, then traversing the list will never yield 
		//a null pointer, and after traversing the linked list as deep as it's depth, there's no sense in trying. 
		//With the tools given to the user the depth always accurately represents the length of the list. i.e it's
		//impossible to have a malformed list, which has the wrong length. 
	}
	
	
	
}
