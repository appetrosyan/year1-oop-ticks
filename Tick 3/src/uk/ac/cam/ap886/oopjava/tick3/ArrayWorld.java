package uk.ac.cam.ap886.oopjava.tick3;

import uk.ac.cam.acr31.life.World;

public class ArrayWorld extends WorldImpl {
	
	private boolean[][] cells;
	
	//-----------------------------------------------
	public 	ArrayWorld(int w, int h) throws PatternFormatException {
	      super(w,h);
	      try{
	      cells = new boolean [h][w];
	      for (int i=0; i<h;i++){
	    	  for (int j=0;j<w;j++){
	    		  cells [i][j] = false;
	    	  }
	      }
	      }
	      catch (ArrayIndexOutOfBoundsException error){
	    	  throw new PatternFormatException ();
	      }
	   }

	public ArrayWorld(ArrayWorld arrayWorld) {
		super (arrayWorld.getWidth(),arrayWorld.getHeight());
		setGeneration(arrayWorld.getGeneration()+1);
		cells = new boolean[getHeight()][getWidth()];
		
	}

	@Override
	public boolean getCell(int col, int row) {
		
		return cells[row][col];
		
	}

	@Override
	public void setCell(int col, int row, boolean alive) {
		cells[row][col]= alive;
			return;

	}

	@Override
	protected World nextGeneration() {
		//Construct a new TestArrayWorld object to hold the next generation:
		ArrayWorld future = new ArrayWorld(this);
	    // Use Loops to update the NEW world cell by cell
	    for (int i=0; i<getWidth();i++){
	    	for (int j=0; j<getHeight(); j++){
	    		future.setCell(i,j,this.computeCell(i, j));
	    	}
	    }
	    return future;
	}

}