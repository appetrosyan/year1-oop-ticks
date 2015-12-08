package uk.ac.cam.ap886.oopjava.tick1;

public class Repeat {
	   public static void main(String[] args) {
	      System.out.println(parseAndRep(args));
	   }
	   public static String parseAndRep(String[] args) {
		   String accum = new String(args[0]);
		   try {
			   if (Integer.parseInt(args[1])<=0){
				   return "Error: second argument is not a positive integer";
			   }
			   for (int i=0; i<Integer.parseInt(args[1])-1;i++) {
				   accum = args[0]+" "+ accum;
				   
			   }
			   return accum;
		   } 
		   catch (NumberFormatException error) {
			   return "Error: second argument is not a positive integer"; 
		   }
		   catch (ArrayIndexOutOfBoundsException error){
			   return "Error: insufficient arguments";
		   }
	   }  
	}
