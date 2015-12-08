package uk.ac.cam.ap886.oopjava.supervision1;

public class VectorAdd {
	/*
	public static void vectorAdd(int x,int y,int dx, int dy) {
		x=x+dx;		
		y=y+dy;
	}
	//This updates only the local copies of the arguments, which aren't references
	
	public static void main(String[] args) {
		int a=0;
		int b=2;
		vectorAdd(a,b,1,1);
		System.out.println(a+" "+b);
		// (a,b) is still (0,2)
	}
	*/
	//The Right way to do it. 
	
	public static void vectorAdd(int []s,int dx, int dy ){
		s[0]=s[0]+dx;
		s[1]=s[1]+dy;
	}
	public static void main(String[] args){
		int [] ab = {0,2};
		vectorAdd(ab, 1,1);
		System.out.println("("+ab[0]+","+ab[1]+")");
		//Outputs (1,3)
		//The trick is in using arrays, which are passed to a function as a reference 
		//the actual array in the heap. Thus this time modifying the values modifies 
		//the obejct in the heap rather than the copy inside the function.
		//
		//Java doesn't allow passing references to primitives (as does C++)
		//So this is perhaps one of the shortest ways to do it. 
	}
	
	
}
