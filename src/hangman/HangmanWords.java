package hangman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class HangmanWords {
	
	public String selectWord(){
	
		String word = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("hangman.txt"));
			Stream<String> str = br.lines();
			Object[] wordArray = str.toArray();
			word = (String)wordArray[(int)(Math.random()*wordArray.length)];
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
				e.printStackTrace();
		}

		return word;
	}
}
