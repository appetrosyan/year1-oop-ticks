package uk.ac.cam.ap886.oopjava.tick3;

public class AuthorCount implements Comparable<AuthorCount> {
	   private String author;
	   private int count;
	   
	   //----------------------------------------------
	   public AuthorCount(String author) {
	      this.author = author;
	      this.count = 1;
	   }
	   
	   
	   public void inc() {
	      count++;
	   }
	   
	   
	   @Override
	   public int hashCode() {
		   return author.hashCode();
	   }
	   
	   @Override
	   public boolean equals(Object obj) {
		  AuthorCount parameter; 
		  if (obj instanceof AuthorCount){
			  parameter = (AuthorCount) obj;
			  return parameter.author.equals(author);
		  }else{
			  return false;
		  }
	   }
	   
	   @Override
	   public int compareTo(AuthorCount o) {
		   if(o.count < count){
			   return -1;
		   }
		   else if (o.count >count){
			   return 1;
		   }
		   else {
			   return (-1)*o.author.compareTo(author);
		   }
		   
	   }
	   
	   @Override
	   public String toString() {
		   return String.format("%-19s %3d", author, count);
		   //	% 19 padding from right, space, 3 padding from left.
	   }
	   
	   public String getAuthor(){
		   return author;
	   }
	   
	}

