package uk.ac.cam.ap886.oopjava.tick3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class CollectionTest {
	
	
   public static List<AuthorCount> processWithList(List<Pattern> patterns) {
      List<AuthorCount> list = new LinkedList<AuthorCount>();
      AuthorCount iterable;
      int index;
      for(Pattern p : patterns) {
    	  	iterable = new AuthorCount (p.getAuthor());
    	  	index = list.indexOf(iterable);
    	  	if(index ==-1){
    		  list.add(new AuthorCount(p.getAuthor()));
    	  	}else{
    		  list.get(index).inc();
    	  	}
    	  	
      }
    
      Collections.sort(list);
      return list;
   }
   
   public static List<AuthorCount> processWithMap(List<Pattern> patterns) {
      Map<String,AuthorCount> map = new HashMap<String,AuthorCount>();
      List<AuthorCount> list = new ArrayList<AuthorCount>();
      for(Pattern p : patterns) {
    	  if(!map.containsKey(p.getAuthor()))
    			  map.put(p.getAuthor(), new AuthorCount(p.getAuthor()));
    	  else
    			  map.get(p.getAuthor()).inc(); 
      }
      
      for (AuthorCount val : map.values()){
    	  list.add(val);
      }
      Collections.sort(list);
      return list;
   }
   
   public static void main(String[] args) throws IOException, PatternFormatException {
	   List <Pattern> pList = new LinkedList<Pattern> ();
	   pList = PatternLoader.loadFromURL("http://www.cl.cam.ac.uk/teaching/current/OOProg/life.txt");
	   
	   System.out.println("Testing HashMap -----------------");
	   List <AuthorCount> aLList = processWithMap (pList);
	   for (AuthorCount a: aLList){
		   System.out.println(a);
	   }
	   aLList = processWithList (pList);
	   System.out.println("Testing List --------------------");
	   for (AuthorCount a: aLList){
		   System.out.println(a);
	   }
   }
}
