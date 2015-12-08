package uk.ac.cam.ap886.oopjava.supervision1;

public class ListStack implements Stack {
	private int top;
	private ListStack body;	
	private boolean overwrite=false;
		
	public ListStack (int val){
		top=val; 
		body=null;
		overwrite =false;				
	}
	public ListStack (int val, ListStack nextLink){
		top=val; 
		body=nextLink;
		overwrite = false;
	}
	//Push really shifts all element one way bottom. Making a method of type 
	//ListStack would have been more efficient, but would have conflicted with our 
	//And in fact every other definition of a stack, and therefore wouldn't be 
	//an implementation. 
	@Override
	public void push(int val) {
			
			int buffer=val;
			
			ListStack current = this;
			while (current.body!=null){
				buffer = current.top;
				current.top = val;
				current = current.body;	
				val=buffer;
			}			
			current.body = new ListStack(current.top);
			current.top = buffer;
			
			
	}
	
	//Recursive Pop, again computationally expensive, because the 
	//Current java system doesn't recognse ListStack as Stack, and
	//Therefore the List-Like implementation is cumbersome. 
	
	@Override
	public 	int pop() {
		int buffer=top;
		if (body ==null){
			System.out.println("Popped Empty stack!!!");
			overwrite = true;
			return top;
		}
		else {
			if(body.body == null){
				top = body.top;
				body= null;
			}
		
			else{
				top=body.top;
				body.pop();
			}
		}
		return buffer;
		
	}

	@Override
	public int depth() {
		ListStack current=this;
		
		int returnValue=1;
		while(current.body!=null){
			current=current.body;
			returnValue++;
		}
		
		return returnValue;
	}
	public void  print() {
		ListStack current=this;
		while(current.body!=null){
			System.out.print(current.top + " ");
			current=current.body;
		}
		System.out.println(current.top);
		System.out.println();
	}
	@Override
	public int peek() {
		return top;
	}
	@Override
	public boolean isEmpty() {
		return overwrite;
	}
	
		
	public static void main(String[] args){
		ListStack test = new ListStack (0);
		System.out.println("Created");
		for(int i=0;i<5;i++){
			System.out.println("Pushed "+(2*i+1));
			test.push(2*i+1);
			test.print();
		}
		System.out.println();
		for(int i=0;i<7;i++){
			System.out.println("Popped "+test.pop()+" expected "+ (2*(4-i)+1));
			System.out.println("Depth " + test.depth()+"\r");
			System.out.print("\n The Stack is ");test.print();
		}
		
	}
	
	

}
