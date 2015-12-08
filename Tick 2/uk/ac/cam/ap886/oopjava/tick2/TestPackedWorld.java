package uk.ac.cam.ap886.oopjava.tick2;

import uk.ac.cam.acr31.life.World;

import java.io.Writer;
import java.awt.Graphics;
import java.io.PrintWriter;

public class TestPackedWorld implements World {

   private int generation;
   private int width=8;
   private int height=8;
   private long cells=0L;
   private static int parsePosition(int col, int row){
	    return col+row*8;
   }
   public TestPackedWorld() {
      for (int i=0; i<8;i++){
    	  for (int j=0;j<8;j++){
    		  cells = PackedLong.set(cells, parsePosition(i,j),false);
    	  }
      }
     //DONE
   }
   
   protected TestPackedWorld(TestPackedWorld prev) {
      generation++;
      //Done
   }
   
   public boolean getCell(int col, int row) {
	return PackedLong.get(cells, parsePosition(col,row)); 
	//Done
   }
   
   public void setCell(int col, int row, boolean alive) { 
	   cells=PackedLong.set(cells, parsePosition(col,row), alive);
	   //Done
   }
   
   public int getWidth()  {
	return 8; 
	//Done
   }
   
   public int getHeight()  {
	return 8;
	//done
   }
   
   public int getGeneration()  {
	return generation;  
	//done
   }
   
   public int getPopulation()  { 
	   return 0; 
	   //Done
   }
   
   public void print(Writer w)  {
	   PrintWriter pw = new PrintWriter (w);
	   pw.println("-");
	   for (int i=0; i<this.getWidth();i++){
		   for (int j=0; j<this.getHeight();j++){
			   pw.print(this.getCell(i, j)? "#":"_");
		   }
		   pw.println();
	   }
	   pw.flush();
	   //Works!!
   }
   public void draw(Graphics g, int width, int height)  { /*Leave empty*/ }
   private TestPackedWorld nextGeneration() {
      //Construct a new TestPackedWorld object to hold the next generation:
      TestPackedWorld world = new TestPackedWorld(this);
      // USe Loops to update the NEW world cell by cell
      for (int i=0; i<width;i++){
    	  for (int j=0; j<height; j++){
    		  world.setCell(i,j,this.computeCell(i, j));
    	  }
      }
      return world;
   }
   public World nextGeneration(int log2StepSize)  { 
      TestPackedWorld world = this;
      int n=1<<log2StepSize;
      for(int i=0;i<n;i++){
         world = world.nextGeneration();
      }
      return world;
   }
   private boolean computeCell(int col,int row) {
    boolean liveCell = this.getCell(col, row);
    //if(this.getCell(col, row))System.out.println("Non-dead cell at "+col+" "+row);
    int neighbours = this.countNeighbours(col, row);
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
   private int countNeighbours(int col, int row){
	    int i=0;
	    i+=getCell(col+1,row) && col!=7?1:0;
	    i+=getCell(col+1,row-1) && col!=7 && row!=0?1:0;
	    i+=getCell(col+1,row+1) && col!=7 && row!=7?1:0;
	    i+=getCell(col,row+1) && row!=7?1:0;
	    i+=getCell(col,row-1) && row!=0?1:0;
	    i+=getCell(col-1,row) && col!=0?1:0;
	    i+=getCell(col-1,row-1) && col!=0 && row !=0?1:0;
	    i+=getCell(col-1,row+1) && col!=0 && row !=7?1:0;
	    return i;
	    }
}