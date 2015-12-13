package uk.ac.cam.ap886.oopjava.tick5;

public class PatternFormatException extends Exception{

	/**
	 * Pattern Format Exception Required by the pattern defined as input for Conway's
	 * game of life implementation as per Computer Science 1A practicals
	 */
	private static final long serialVersionUID = 1L;
	
	
	//---------------------------------------------
	public PatternFormatException() {
		super("Please specify a pattern.");		
	}
	public PatternFormatException(int x) {
		super("Invalid pattern format: Incorrect number of fields in pattern (found " + x +").");
	}
	public PatternFormatException(String field, String problem) {
		super("Invalid pattern format: Could not interpret the "+field+" field as a number ('" + problem + "' given).");
	}
	public PatternFormatException(String malformedPattern){
		super ("Invalid pattern format: Malformed pattern '010 0a1 111'.");
	}
	

}
