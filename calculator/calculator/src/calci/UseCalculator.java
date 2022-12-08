package calci;

import java.io.*;

public class UseCalculator
{
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


		System.out.println("calculatore - b ,Scientific - S."); 
																		
		System.out.flush();
		String option = buffer.readLine();

		if (option.length() == 1) {
			
			if (option.equals("B") || option.equals("b")) {

				calculator c = new calculator();
				c.Calc();
			} 
			
			else if (option.equals("S") || option.equals("s")) {
				ScientificCalculator sc = new ScientificCalculator();
				sc.Calc();
			} 
			
			else {
				System.out.println("Please enter correct letter");
			}
		} 
	}
}