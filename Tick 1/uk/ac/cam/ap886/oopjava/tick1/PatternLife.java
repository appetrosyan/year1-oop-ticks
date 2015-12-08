package uk.ac.cam.ap886.oopjava.tick1;

public class PatternLife {

    
	public static void main(String[] args) throws java.io.IOException, PatternFormatException {
		try{
			try{ 
				Pattern p = new Pattern(args[0]);
			//System.out.println("This is SPatternLife!");
			boolean[][] world = new boolean[p.getHeight()][p.getWidth()];
			p.initialise(world);
			play(world);
			}
			catch (ArrayIndexOutOfBoundsException error){
				throw new PatternFormatException();
			}
		}
		catch (PatternFormatException error) {
			System.out.println (error.getMessage());
		}
	}
    
    //Maintenance Methods
    public static boolean getCell(boolean[][] world, int col, int row) {
    if (row < 0 || row > world.length - 1) return false;
    if (col < 0 || col > world[row].length - 1) return false;

    return world[row][col];
    }
    public static void setCell(boolean[][] world, int col, int row, boolean value){
        if (row < 0 || row > world.length - 1) return ;
        if (col < 0 || col > world[row].length - 1) return ;
        world[row][col]=value;
    }
    //output
    public static void print(boolean[][] world) { 
        System.out.println("-"); 
        for (int row = 0; row < world.length; row++) { 
            for (int col = 0; col < world[row].length; col++) {
                System.out.print(getCell(world, col, row) ? "#" : "_"); 
            }
            System.out.println(); 
        } 
  
    }
    public static void play(boolean[][] world) throws java.io.IOException {
        int userResponse = 0;
        boolean[][] future= new boolean[world.length][world[0].length];
        while (userResponse != 'q') {
            for (int row = 0; row < world.length; row++) { 
                for (int col = 0; col < world[row].length; col++) {
                    setCell(future,col,row,nextGeneration(world)[row][col]);
                }
            } 
            print(world);
            userResponse = System.in.read();
            //world = nextGeneration(world);
            
            for (int row = 0; row < world.length; row++) { 
                for (int col = 0; col < world[row].length; col++) {
                    setCell(world,col,row,future[row][col]);
                }
            } 
        }
    }
    //Next Generation Generation
    public static int countNeighbours(boolean[][] world, int col, int row){
	    int i=0;
	    i+=getCell(world,col+1,row)?1:0;
	    i+=getCell(world,col+1,row-1) ?1:0;
	    i+=getCell(world,col+1,row+1)?1:0;
	    i+=getCell(world,col,row+1)?1:0;
	    i+=getCell(world,col,row-1)?1:0;
	    i+=getCell(world,col-1,row)?1:0;
	    i+=getCell(world,col-1,row-1)?1:0;
	    i+=getCell(world,col-1,row+1)?1:0;
	    return i;
    }
    public static boolean computeCell(boolean[][] world,int col,int row) {

    	boolean liveCell = getCell(world, col, row);
        int neighbours = countNeighbours(world, col, row);

    // we will return this value at the end of the method to indicate whether 
    // cell (col,row) should be live in the next generation
    boolean nextCell = false;
            
    //A live cell with less than two neighbours dies (underpopulation)
    if (neighbours < 2) {
        nextCell = false;
    }
    //A live cell with two or three neighbours lives (a balanced population)
    if(neighbours > 1 && neighbours < 4 && liveCell){
        nextCell = true;
    }
    //A live cell with with more than three neighbours dies (overcrowding)
    if(neighbours > 3 && liveCell) {
        nextCell = false;
    }
    //A dead cell with exactly three live neighbours comes alive
    if(neighbours== 3 && !liveCell) {
    nextCell = true;
    }

            
    return nextCell;
    }
    public static boolean[][] nextGeneration(boolean[][] world) { 
        boolean[][] future = new boolean[world.length][world[0].length];
        for (int row = 0; row < world.length; row++) { 
            for (int col = 0; col < world[row].length; col++) {
                setCell(future,col,row,computeCell(world,col,row));
            }
        } 
    return future;
    }
    
}
