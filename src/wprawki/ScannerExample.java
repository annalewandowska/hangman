package wprawki;

import java.io.File;
import java.util.Scanner;


public class ScannerExample {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String name;
		int age;
		
		System.out.print("Podaj imie: ");
		name = in.nextLine();
		System.out.println(name);
		
		System.out.print("Podaj wiek: ");
		age = in.nextInt();
		System.out.println(age);
		
		try(Scanner inF = new Scanner(new File("test.txt"))){
	
		while(inF.hasNext()){
			System.out.print(inF.next());
		}
		inF.close();
		}catch (Exception e){}
	}
}
