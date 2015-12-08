package uk.ac.cam.ap886.oopjava.tick2;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import uk.ac.cam.acr31.life.World;

public class RefactorLife {

	public static void main(String[] args) throws PatternFormatException, IOException {
		if (args.length != 1 && args.length != 2) {
			System.out.println("RefactorLife [optional worldType] [pattern]");
			return;
		}
		
		String worldType = 	args.length == 	2? args[0] : "--array"	;
		if(args.length ==1 && (args[0].equals("--long") || (args[0].equals("--array")))){
			System.out.println("Please specify a pattern.");
			return;
		}
		String worldPattern = 	args.length 	== 		2? args[1] : args[0];
		Pattern p = new Pattern (worldPattern);
		World world = null;
		if (worldType.equals("--array")) {
			world = new ArrayWorld(p.getWidth(),p.getHeight());
		}
		else if (worldType.equals("--long")) {
			world = new PackedWorld();
		} 
		else {
			System.out.println("ERROR: Unrecognised World Type Specified");
		return;
		}
			p.initialise(world);
			play(world);
		}
		/*public static void main(String[] args) throws java.io.IOException, PatternFormatException {
		try{
			if(args[0].equals("--long")){
				Pattern p = new Pattern (args[1]);
				World world = new TestPackedWorld();
				p.initialise(world);
				play(world);
			}
			else {
				Pattern p = new Pattern(args[args[0].equals("--array")?1:0]);
				//System.out.println("This is SPatternLife!");
				World world = new TestArrayWorld(p.getWidth(),p.getHeight());
				p.initialise(world);
				play(world);
			}
			
			
		}
		catch (PatternFormatException error) {
			System.out.println (error.getMessage());
		}
	}																																																									
    */
    public static void play(World world) throws java.io.IOException {
        int userResponse = 0;
        Writer w = new OutputStreamWriter(System.out);
        while (userResponse != 'q') {
        	
        	world.print(w);
            userResponse = System.in.read();
            //System.out.println(userResponse);
            world = world.nextGeneration(0);
        }
    }
    
}
