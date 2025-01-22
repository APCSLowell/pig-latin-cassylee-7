import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
	        int index = 0;
	  if (sWord.length() == 0)
	    index = -1;
	  for (int i = 0; i < sWord.length(); i++) {
	    if (sWord.substring(i, i + 1).equals("a")) {
	      index = i;
	      break;
	    }
	    if (sWord.substring(i, i + 1).equals("e")) {
	      index = i;
	      break;
	    }
	    if (sWord.substring(i, i + 1).equals("i")) {
	      index = i;
	      break;
	    }
	    if (sWord.substring(i, i + 1).equals("o")) {
	      index = i;
	      break;
	    }
	    if (sWord.substring(i, i + 1).equals("u")) {
	      index = i;
	      break;
	    }
	    if (i + 1 == sWord.length()) {
	      index = -1;
	      break;
	    }
	  }
	  return index;
	}

    public String pigLatin(String sWord) {
	     if (findFirstVowel(sWord) == -1)
	  {
	    return sWord + "ay";
	  }
	  if (sWord.substring(0, 2).equals("qu"))
	    return sWord.substring(2) + sWord.substring(0, 2) + "ay";
	  else
	  {
	    return sWord.substring(findFirstVowel(sWord)) + sWord.substring(0, findFirstVowel(sWord)) + "ay";
	  }
	}
}//end PigLatin class
