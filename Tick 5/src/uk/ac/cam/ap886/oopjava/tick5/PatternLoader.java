package uk.ac.cam.ap886.oopjava.tick5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class PatternLoader {
	//---------------------------------------------
	public static List<Pattern> load(Reader r) throws IOException {
		BufferedReader buffer = new BufferedReader(r);
		List<Pattern> resultList = new LinkedList<Pattern>();
		Pattern  p = null;
		String temp = new String("Initialiser");
		while( temp !=null) {
			try{
				p = new Pattern(temp);
				resultList.add(p);
				temp = buffer.readLine();
			}
			catch (PatternFormatException err){
				temp = buffer.readLine();//Ignore the first line and 
				continue;				//trailing incorrectly formatted lines;
			}		
		}
		return resultList.isEmpty()?null:resultList;
	}
	
	public static List<Pattern> loadFromURL(String url) throws IOException {
		URL destination = new URL(url);
		URLConnection conn = destination.openConnection();
		return load(new InputStreamReader(conn.getInputStream()));
	}
	
	public static List<Pattern> loadFromDisk(String filename) throws IOException {
		return load(new FileReader(filename));
	}
	

}