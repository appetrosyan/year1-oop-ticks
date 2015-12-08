package uk.ac.cam.ap886.oopjava.supervision1;

public class MatrixMaker {
	public static float[][] makeMatrix (int n){
		return new float[n][n];
		
	}
	public static float[][] copyMatrix (float [] q){
		int n = (int)(Math.sqrt(q.length));
		float[][] returnValue = makeMatrix(n);
		
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				returnValue[i][j]=q[i+n*j];
			}
		}
		return returnValue;
	}
	
	public static void main(){
		/*
		 * Returns a reference to the newly created matrix.
		 * 
		 * The above definition might look like it uses 
		 * multidimensional arrays, but it doesn't. If we
		 * assigned it to a variable, e.g. by saying. 
		 */
		 //float [] a = new float [5];
		  
		 // THen this would be a valid statement
		 //a = makeMatrix(5) [0];
	}
		
		 	
	
}
