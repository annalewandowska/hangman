package hangman;

public class HangmanCheckLetter {

	public boolean checkLetter(char c, String word, char[] tmpCharTable){
		
		boolean hasChar = false;
		
		if(word.toLowerCase().contains(String.valueOf(c))){
			for(int i = 0; i < word.length(); i++){
				if(c == word.toLowerCase().toCharArray()[i]){
					tmpCharTable[i] = c;
				}
				if(' ' == word.toLowerCase().toCharArray()[i]){
					tmpCharTable[i] = ' ';
				}
			}
			hasChar = true;
		}
		
		for(int i = 0; i<tmpCharTable.length; i++){
			System.out.print(tmpCharTable[i]);	
		}
		System.out.println();
	return hasChar;
	}
}
