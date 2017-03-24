//Anna Lewandowska
/* gra wisielec, klasa g��wna HangmanApp, wykorzystuje klas� HangmanCheckLetter 
 * (metoda checkLetter() sprawdza liter� podan� przez gracza) 
 * oraz HangmanWords (metoda chooseWord() losuje wyra�enie z pliku hangman.txt
 * w pliku s� zapisane wyra�enia dwuwyrazowe*/

package hangman;

import java.util.Scanner;

public class HangmanApp {

	public static void main(String[] args){
		
		char c;
		int counter = 8;
		boolean hasChar = false; 
		String lettersGiven = "";
		
		HangmanWords hw = new HangmanWords();
		String word = hw.selectWord();

		HangmanCheckLetter hcl = new HangmanCheckLetter();
		char[] tmpCharTable = new char[word.length()];
		for(int i = 0; i < tmpCharTable.length; i++){
			tmpCharTable[i] = '.';
		}
		
		Scanner in = new Scanner(System.in);
		
		while(counter > 0){
			
			System.out.println("Podaj liter�: ");
			c = in.next().charAt(0);
			
			//sprawdzam czy znak jest liter� i konwertuj� na ma�� liter�
			if(!Character.isLetter(c)){
				System.out.println("To nie jest litera.");
				continue;
			}
			c = String.valueOf(c).toLowerCase().charAt(0);
			
			/*sprawdzam, czy gracz podawa� ju� wcze�niej t� liter�*/
			if(lettersGiven.contains(String.valueOf(c))){
			//	isRepetition = true;
				System.out.println("Podawa�e� ju� t� liter�.");
				continue;
			}
			lettersGiven = lettersGiven + String.valueOf(c);
	//		guessNo++;

			/*sprawdzam, czy s�owo zawiera liter� podan� przez gracza*/
			hasChar = hcl.checkLetter(c, word, tmpCharTable);
			
			if(word.equals(String.valueOf(tmpCharTable))){
				System.out.println("Brawo! Uda�o Ci si� odgadn��");
				break;
			} else if (counter != 1){
				System.out.println("Pr�buj dalej!");
				}
			
			if(!hasChar) {
				counter--;
				}
			
			if(counter == 1) {
				System.out.println("Zosta�a Ci " +counter+ " pr�ba");
			}
			if(counter == 2 || counter == 3 || counter == 4) {
				System.out.println("Zosta�y Ci " +counter+ " pr�by");
			}
			if(counter > 4){
				System.out.println("Zosta�o Ci " +counter+ " pr�b");
			}
		}
		if (counter == 0) {
			System.out.println("Przegra�e�/a�! Odgadywany wyraz to: "+ word);
		}
		
		in.close();
	}
	
}
