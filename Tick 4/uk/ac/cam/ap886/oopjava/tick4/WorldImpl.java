package uk.ac.cam.ap886.oopjava.tick4;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;
import java.io.Writer;


import uk.ac.cam.acr31.life.World;


public abstract class WorldImpl implements World {
   private int width;
   private int height;
   private int generation;
   
   //---------------------------------------------
   protected WorldImpl(int width, int height) {
      this.width = width;
      this.height = height;
      this.setGeneration(0);
   }
   
   protected WorldImpl(WorldImpl prev) {
      this.width = prev.width;
      this.height = prev.height;
      this.setGeneration(prev.getGeneration() + 1);
   } 

   public int getWidth() { 
	   return width; 
   }
   
   public int getHeight() { 
	   return height; 
   }
   
   public int getGeneration() { 
	   return generation;
   }
   
   public int getPopulation() { 
	   return 0;
   }
   
   protected String getCellAsString(int col,int row) {
      return getCell(col,row) ? "#" : "_";
   }
   
   
   protected Color getCellAsColour(int col,int row) {
      return getCell(col,row) ? Color.BLACK : Color.WHITE;
   }  
   
   public void draw(Graphics g,int width, int height) {
	   int worldWidth = getWidth();
	   int worldHeight = getHeight();
	   double colScale = (double)width/(double)worldWidth;
	   double rowScale = (double)height/(double)worldHeight;
	   for(int col=0; col<worldWidth; ++col) {
	      for(int row=0; row<worldHeight; ++row) {
	         int colPos = (int)(col*colScale);
	         int rowPos = (int)(row*rowScale);
	         int nextCol = (int)((col+1)*colScale);
	         int nextRow = (int)((row+1)*rowScale);
	         if (g.hitClip(colPos,rowPos,nextCol-colPos,nextRow-rowPos)) {
	            g.setColor(getCellAsColour(col, row));
	            g.fillRect(colPos,rowPos,nextCol-colPos,nextRow-rowPos);
	         }
	      } 
	   }  
	 }
    
   public World nextGeneration(int log2StepSize)  { 
	      WorldImpl world = this;
	      int n=1<<log2StepSize;
	      for(int i=0;i<n;i++){
	         world = (WorldImpl) world.nextGeneration();
	      }
	      return world;
	   }
   
   public void print(Writer w) {
	   PrintWriter pw = new PrintWriter (w);
	   pw.println("-");
	   for (int j=0; j<this.getHeight();j++){
		   for (int i=0; i<this.getWidth();i++){		   
			   pw.print(this.getCellAsString(i, j));
		   }
		   pw.println();
	   }
	   pw.flush();
   }
   
   protected int countNeighbours(int col, int row) {
	   int i=0;
	    i+=col!=(getWidth()-1) && getCell(col+1,row) 				?1:0;
	    i+=col!=(getWidth()-1) && row!=0 && getCell(col+1,row-1) 	?1:0;
	    i+=col!=(getWidth()-1) && row!=(getHeight()-1) && getCell(col+1,row+1) ?1:0;
	    i+=row!=(getHeight()-1) && getCell(col,row+1)				?1:0;
	    i+=row!=0 && getCell(col,row-1) 						?1:0;
	    i+=col!=0 && getCell(col-1,row)							?1:0;
	    i+=col!=0 && row !=0 && getCell(col-1,row-1)			?1:0;
	    i+=col!=0 && row !=(getHeight()-1) && getCell(col-1,row+1)	?1:0;
	    return i;
   }
   
   protected boolean computeCell(int col,int row) {
	    boolean liveCell = this.getCell(col, row);
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
      
   
   public abstract boolean getCell(int col,int row);
   
   public abstract void setCell(int col, int row, boolean alive);
   
   protected abstract World nextGeneration();

   public void setGeneration(int generation) {
	this.generation = generation;
   }
   
}