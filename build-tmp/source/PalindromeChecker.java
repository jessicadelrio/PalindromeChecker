import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}

public boolean palindrome(String word)
{ //first I made a new variable to put only the letters 
  String newWord = "";
  for(int i = 0; i < word.length(); i++){
    if(Character.isLetter(word.charAt(i))==true){
      newWord = newWord + word.substring(i,i+1);
    
    }
    
  }
//then I made another variable so that we can make it have no spaces
  String noSpaces = "";
  
    for(int i = 0; i < newWord.length();i++){
      if(newWord.charAt(i)!=' '){
        noSpaces = noSpaces + newWord.substring(i,i+1);

      }
    }
    String lowerWord = noSpaces.toLowerCase();
    int theNum = 0;
    for(int i = 0; i < lowerWord.length();i++){
        
      //if(lowerWord.substring(i,i+1).equals(lowerWord.substring(lowerWord.length()-i-1,lowerWord.length()-i))){
        if(lowerWord.charAt(i) == lowerWord.charAt(lowerWord.length()-i-1)){
        theNum = theNum + 1;
      }
    }
    if(theNum == lowerWord.length()){
      return true;
    }

  return false;
  
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
