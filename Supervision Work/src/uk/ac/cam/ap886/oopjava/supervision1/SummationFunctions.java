package uk.ac.cam.ap886.oopjava.supervision1;

public class SummationFunctions {
	int sum (int[] a){
		int returnValue=0;
		try {
			for (int i=0;i<a.length;i++){
				returnValue +=a[i];				
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Supplied array not initialised");//Shoudln't happen
											//Better Safe than sorry
		}
		return returnValue;
	}
	int[] cumsum (int[] a){
		int[] returnValue=new int [a.length];// Creates a new object to point to 
		try {
			int i=0;
			while (i<a.length){ 			//Exact equivalent of the above for 
				returnValue[i] = a[i]+returnValue[i-1];	//Adds the elements creating 
							i++;	//the CUmulative sum of the elements of the array.
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Supplied array not initialised");//Shoudln't happen
											//Better Safe than sorry
		}
		return returnValue;
		
	}
	int[] positives (int[] a){
		int[] returnValue;
		//Count how many positives are there first.
		int q=0;
		for (int i=0; i<a.length;i++){
			if (a[i]>0) q++;
		}
		returnValue = new int[q];
		//Add the Variables to a new array
		q=0;
		for(int i=0;i<a.length;i++){
			if (a[i]>0) {
				returnValue[q]=a[i];
				q++;
			}
		}
		return returnValue; //Return a reference to the array with all positives. 
		
	}
}
