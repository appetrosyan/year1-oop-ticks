package uk.ac.cam.ap886.oopjava.tick4;


public class CommandLineOptions {

	public static String WORLD_TYPE_LONG = "--long";
	public static String WORLD_TYPE_AGING = "--aging";
	public static String WORLD_TYPE_ARRAY = "--array";
	private String worldType = null;

	//----------------------------------
	public String getWorldType() {
		return worldType;
	}

	public Integer getIndex() {
		return index;
	}

	public String getSource() {
		return source;
	}

	private Integer index = null;
	private String source = null;

	public CommandLineOptions(String[] args) throws CommandLineException {
		//	 parse "args" to update the private fields "worldType", 
		//      "index" and "source" with the correct values, if any.
		if(args.length==0){
			throw new CommandLineException("Error: No arguments found");
		}

		//Check if there's a pattern Type specified
		int hasFirst=0;
		if(args[hasFirst].startsWith("--")){
			hasFirst++;
			worldType = args[0];		
		}else{
			worldType ="--aging";
			//Revert to default
		}

		//Get Pattern Source & index
		if(args.length ==1 && hasFirst==1){
			throw new CommandLineException("Please specify a pattern source.");
		}else{			
			source = args[hasFirst];
			if(args.length >= 2+hasFirst){
				try{
					index = Integer.parseInt(args[hasFirst+1]);
					if(index<0){
						throw new CommandLineException("Error: Index out of bounds" );
					}
				}catch (NumberFormatException error){
					throw new CommandLineException("Could not interpret patternIndex "
							+ "as an integer (given '"+args[hasFirst+1]+"').");
				}
			}
		}
	}

}


