package uk.ac.cam.ap886.oopjava.tick2;

import uk.ac.cam.acr31.life.World;

import java.io.Writer;
import java.awt.Graphics;
import java.io.PrintWriter;

public class TestArrayWorld implements World {

   private int generation;
   private int width;
   private int height;
   private boolean[][] cells;
   public 		TestArrayWorld(int w, int h) {
      width = w;
      height = h;
      generation = 0;
      cells = new boolean [width][height];
      for (int i=0; i<w;i++){
    	  for (int j=0;j<h;j++){
    		  cells [i][j] = false;
    	  }
      }
     //DONE
   }
   
   protected 	TestArrayWorld(TestArrayWorld prev) {
      width = prev.width;
      height = prev.height;
      generation++;
      cells = new boolean [width][height];
      //Done
   }
   
   public boolean getCell(int col, int row) {
	return cells[col][row]; 
   }
   
   public void 	setCell(int col, int row, boolean alive) { 
	   cells[col][row] = alive;
   }
   
   public int 	getWidth()  {
	return width; 
   }
   
   public int 	getHeight()  {
	return height;  
   }
   
   public int 	getGeneration()  {
	return generation;  
   }
   
   public int 	getPopulation()  { 
	   return 0; 
   }
   
   public void 	print(Writer w)  {
	   PrintWriter pw = new PrintWriter (w);
	   pw.println("-");
	   for (int i=0; i<this.getWidth();i++){
		   for (int j=0; j<this.getHeight();j++){
			   pw.print(this.getCell(i, j)? "#":"_");
		   }
		   pw.println();
	   }
	   pw.flush();
   }
   
   public void 	draw(Graphics g, int width, int height)  { /*Leave empty*/ }
   private 		TestArrayWorld nextGeneration() {
      //Construct a new TestArrayWorld object to hold the next generation:
	  TestArrayWorld future = new TestArrayWorld(this);
      // Use Loops to update the NEW world cell by cell
      for (int i=0; i<width;i++){
    	  for (int j=0; j<height; j++){
    		  future.setCell(i,j,this.computeCell(i, j));
    	  }
      }
      return future;
   }
   
   public 		World nextGeneration(int log2StepSize)  { 
      TestArrayWorld world = this;
      int n=1<<log2StepSize;
      for(int i=0;i<n;i++){
         world = world.nextGeneration();
      }
      return world;
   }
   
   private boolean computeCell(int col,int row) {
	    boolean liveCell = this.getCell(col, row);
	    int neighbours = countNeighbours(this ,col, row);
	    boolean nextCell = false;
	    if (neighbours < 2) {
	        nextCell = false;
	    }
	    if(neighbours > 1 && neighbours < 4 && liveCell){
	        nextCell = true;
	    }
	    if(neighbours > 3 && liveCell) {
	        nextCell = false;
	    }
	    if(neighbours== 3 && !liveCell) {
	    nextCell = true;
	    }
	    return nextCell;
   }
   
   private static int 	countNeighbours(World world, int col, int row){
	    int i=0;
	    try{i+=world.getCell(col+1,row)		?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col+1,row+1)	?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col,row+1)		?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col+1,row-1) 	?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col,row-1) 		?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col-1,row) 		?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col-1,row-1) 	?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    try{i+=world.getCell(col-1,row+1) 	?1:0;}
	    catch (ArrayIndexOutOfBoundsException e){}
	    return i;
   }
   
}
