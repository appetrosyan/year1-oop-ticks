package uk.ac.cam.ap886.oopjava.tick3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import uk.ac.cam.acr31.life.World;
import uk.ac.cam.acr31.life.WorldViewer;

public class LoaderLife{

	public static void main(String[] args)throws java.io.IOException, PatternFormatException{
		List <Pattern> patternList = new LinkedList <Pattern>();
		String worldType=null; 
		Pattern p =null;
		int index =0;
		World currentWorld = null;

		if(args.length==0){
			System.out.println("LoaderLife [optional worldType] [patternSource] [option patternIndex]");
			return;
		}

		//Check if there's a pattern Type specified
		int i=0;
		if(args[i].startsWith("--")){
			i++;
			worldType = args[0];		
		}else{
			worldType ="--aging";
		}

		//Get PatternFrom Source
		if(args.length ==1 && i==1){
			System.out.println("Please specify a pattern source.");
			return;
		}
		else if(args[i].startsWith("http://")){
			try{
				patternList = PatternLoader.loadFromURL(args[i]);
			}catch (IOException e){
				System.out.println("An error occurred loading from URL: " + args[i]);
				return;
			}
		}
		else{
			try{
				patternList = PatternLoader.loadFromDisk(args[i]);
			}catch (IOException error){
				System.out.println("An error occurred loading from file: "+args[i]);
				return;
			}
		}

		//Get Index
		if(i+1 >= args.length){
			print(patternList);
			return;
		}
		else{
			try{
				index = Integer.parseInt(args[i+1]);
			}catch (NumberFormatException error){
				System.out.println("Could not interpret patternIndex as an integer (given '"+args[i+1]+"').");
				return;
			}
		}

		//Get Pattern with Index
		try{
			p = patternList.get(index);
		}catch (IndexOutOfBoundsException error){
			System.out.println("Chosen index number not present in list.");
			return;
		}

		//Create a world of the required type
		if(worldType.equals("--aging")){
			currentWorld = new AgingWorld (p.getWidth(),p.getHeight());
		}
		else if(worldType.equals("--array")){
			currentWorld = new ArrayWorld (p.getWidth(),p.getHeight());
		}
		else if(worldType.equals("--long")){
			currentWorld = new PackedWorld ();
		}
		else{
			System.out.println("Unrecognised World Type." + worldType);
			return;
		}
		p.initialise(currentWorld);
		play(currentWorld);
	}

	public static void print (List <Pattern> list){
		int counter=0;
		for (Pattern p :list){
			System.out.println(counter+"\t"+p.getName()+"\t"+p.getAuthor());
			counter++;
		}
	}

	public static void play(World world) throws java.io.IOException {
		int userResponse = 0;
		WorldViewer viewer = new WorldViewer();
		Writer w = new OutputStreamWriter(System.out);
		while (userResponse != 'q') {
			viewer.show(world);
			world.print(w);
			userResponse = System.in.read();
			world = world.nextGeneration(0);
		}
	}


}
