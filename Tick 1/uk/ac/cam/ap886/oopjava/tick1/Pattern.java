package uk.ac.cam.ap886.oopjava.tick1;


public class Pattern {

   private String name;
   private String author;
   private int width;
   private int height;
   private int startCol;
   private int startRow;
   private String cells;
   //Getters
   public String getName() {
      return name;
   }
   public String getAuthor(){
	   return author;
   }
   public int getWidth(){
	   return width;
   }
   public int getHeight(){
	   return height;
   }
   public int getStartCol(){
	   return startCol;
   }
   public int getStartRow(){
	   return startRow;
   }
   public String getCells(){
	   return cells;
   }
   public Pattern(String format) throws PatternFormatException {

	   String [] parts = format.split(":");
	   try {
		   name 	= parts [0];
		   author 	= parts [1];
		   try {
		   width 	= Integer.parseInt(parts[2]);
		   }
		   catch (NumberFormatException error) {
			   throw new PatternFormatException("width", parts[2]);
		   }
		   try {
		   height 	= Integer.parseInt(parts[3]);
		   }
		   catch (NumberFormatException error) {
			   throw new PatternFormatException("height", parts[3]);
		   }
		   try{
		   startCol = Integer.parseInt(parts[4]);
		   }
		   catch (NumberFormatException error) {
			   throw new PatternFormatException("startX", parts[4]);
		   }
		   try{
		   startRow	= Integer.parseInt(parts[5]);
		   }
		   catch (NumberFormatException error) {
			   throw new PatternFormatException("startY", parts[5]);
		   }
		   cells = parts[6];
	   }
	   catch  (ArrayIndexOutOfBoundsException error){
		    throw new PatternFormatException (parts.length);
		   	   
	   }
	      
}
   public void initialise(boolean[][] world) throws PatternFormatException {
	  String[] initpattern = cells.split(" "); 
	  char [] curline;
	  for (int i =0; i<initpattern.length; i++){
		   curline = initpattern[i].toCharArray();
		   for (int j=0; j<curline.length;j++){
			   if(curline[j]=='1' || curline[j] == '0'){
				   world [i+startRow][j+startCol] = curline [j]=='1';
			   }
			   else{			   
				   throw new PatternFormatException (cells);
			   }
		   }
	  }
	  
   }
   
   
	} 
