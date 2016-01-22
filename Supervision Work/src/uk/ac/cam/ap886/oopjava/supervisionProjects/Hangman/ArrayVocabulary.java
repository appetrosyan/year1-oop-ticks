package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ArrayVocabulary extends Vocabulary {

	//------------------------------------------
	public ArrayVocabulary(String filename) throws FileNotFoundException, IOException{
		loadFromFile(filename);
	}
	
	public boolean loadFromFile(String filename) throws FileNotFoundException, IOException{
			words = new ArrayList<String>();
			//Selects a specific implmentation
			
			try (BufferedReader r = new BufferedReader (new FileReader (filename));){
				String temp = "";
				do{
					temp= r.readLine();
					words.add(temp);
				}while(temp!=null);
			} 
			if(words.isEmpty()){
				return false;
			}else{
				return true;
			}
		
	}

	public ArrayVocabulary () throws FileNotFoundException, IOException{
		this("words.txt");
	}

	public String getRandomWord(){
		Random random = new Random();
		int size = words.size();
		int index = random.nextInt(size);
		return words.get(Math.abs(index));
	}


	/*
	public static void main(String []args){
		ArrayDictionary test;
		try {
			test = new ArrayDictionary();
			for(int i=0;i<10;i++){
				System.out.println(i+" "+test.getRandomWord());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}
	*/

	//Complete
}
