package wprawki;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		double x;
		double y;
		char c;	
		double tmpresult = 0;
		double result = 0;
		String str;
		
		System.out.println("Podaj r�wnanie do rozwi�zania i zako�cz �rednikiem ");
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(in.nextLine());
		in.close();
		
		x = in2.nextDouble();
		y = in2.nextDouble();
		c = in2.next().charAt(0);
		
		tmpresult = calculation(x, y, c);
		
		 while(in2.hasNext()){
			 Double x2 = tmpresult;
			 Double y2 = in2.nextDouble();
			 char c2 = in2.next().charAt(0);
			 result = calculation(x2, y2, c2);
		 }
		 
		 System.out.println(tmpresult);
		 System.out.println(result);
		 in2.close();
	}

	public static double calculation(double x, double y, char c){
		double result = 0;
		
		switch(c){
			case '+': 
				result = x+y;
				break;
			case '-': 
				result = x-y;
				break;
			case '*': 
				result = x*y;
				break;				
			case '/': 
				if(y == 0){
					System.out.println("Dzielisz przez zero!");
					break;
				}else 	{result = x/y;}
		}
	
		return result;
	}
}
