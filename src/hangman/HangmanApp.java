//Anna Lewandowska
/* gra wisielec, klasa g³ówna HangmanApp, wykorzystuje klasê HangmanCheckLetter 
 * (metoda checkLetter() sprawdza literê podan¹ przez gracza) 
 * oraz HangmanWords (metoda chooseWord() losuje wyra¿enie z pliku hangman.txt
 * w pliku s¹ zapisane wyra¿enia dwuwyrazowe*/

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
			
			System.out.println("Podaj literê: ");
			c = in.next().charAt(0);
			
			//sprawdzam czy znak jest liter¹ i konwertujê na ma³¹ literê
			if(!Character.isLetter(c)){
				System.out.println("To nie jest litera.");
				continue;
			}
			c = String.valueOf(c).toLowerCase().charAt(0);
			
			/*sprawdzam, czy gracz podawa³ ju¿ wczeœniej tê literê*/
			if(lettersGiven.contains(String.valueOf(c))){
			//	isRepetition = true;
				System.out.println("Podawa³eœ ju¿ tê literê.");
				continue;
			}
			lettersGiven = lettersGiven + String.valueOf(c);
	//		guessNo++;

			/*sprawdzam, czy s³owo zawiera literê podan¹ przez gracza*/
			hasChar = hcl.checkLetter(c, word, tmpCharTable);
			
			if(word.equals(String.valueOf(tmpCharTable))){
				System.out.println("Brawo! Uda³o Ci siê odgadn¹æ");
				break;
			} else if (counter != 1){
				System.out.println("Próbuj dalej!");
				}
			
			if(!hasChar) {
				counter--;
				}
			
			if(counter == 1) {
				System.out.println("Zosta³a Ci " +counter+ " próba");
			}
			if(counter == 2 || counter == 3 || counter == 4) {
				System.out.println("Zosta³y Ci " +counter+ " próby");
			}
			if(counter > 4){
				System.out.println("Zosta³o Ci " +counter+ " prób");
			}
		}
		if (counter == 0) {
			System.out.println("Przegra³eœ/aœ! Odgadywany wyraz to: "+ word);
		}
		
		in.close();
	}
	
}
