package uk.ac.cam.ap886.oopjava.tick5;

import uk.ac.cam.acr31.life.World;

public class PackedWorld extends WorldImpl {
	private long cells;

	//----------------------------------
	protected PackedWorld(WorldImpl prev) {
		super(prev);
		cells = 0L;
	}

	protected PackedWorld() {
		super(8, 8);
		cells = 0L;
	}	

	private static int parsePosition(int col, int row){
		return col+row*8;
	}	

	@Override
	public boolean getCell(int col, int row) {
		return PackedLong.get(cells, parsePosition(col,row));
	}

	@Override
	public void setCell(int col, int row, boolean alive) {
		cells = PackedLong.set(cells, parsePosition(col,row), alive);

	}

	@Override
	protected World nextGeneration() {
		PackedWorld world = new PackedWorld(this);
		for (int i=0; i<getWidth();i++){
			for (int j=0; j<getHeight(); j++){
				world.setCell(i,j,this.computeCell(i, j));
			}
		}
		return world;
	}

}
