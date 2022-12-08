package calci;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import calci.calculate;

public class calculator extends calculate {
	public void Calc() throws java.io.IOException {
		boolean next;

		do {                                               //for repeated inputs
			Integer FirstNumber = new Integer(0);
			Integer SecondNumber = new Integer(0);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Please enter First Number: "); // get user input
			System.out.flush();

			try {
				FirstNumber = Integer.parseInt(buffer.readLine());
			} catch (NumberFormatException e) {
				System.out.println("*///*Please provide numeric values.*///*");
				System.exit(0);
			}

			System.out.println("Please enter the Operation (Add : +, Minus : -, Product : *, Divide : /):");
			System.out.flush();
			String option = buffer.readLine();

			System.out.println("Please enter Second Number: ");
			System.out.flush();

			try {
				SecondNumber = Integer.parseInt(buffer.readLine(), 10);
			} catch (NumberFormatException e) {
				System.out.println("*///*Please provide numeric values.*///*");
				System.exit(0);
			}

			if (option.length() == 1) {

				calculate c = new calculate(FirstNumber, option.charAt(0), SecondNumber); // // Creates Calculate
																							// Class Instance

		
				c.doCalculation();
				c.getResult();
			} else {
				System.out.println("*///*Operation Not Available. Please select any of the available options.*///*");
			}

			// Checks if the user would like to calculate again
			System.out.println("Would you like to calculate again (y/n)?");
			System.out.flush();
			char response = (char) buffer.read();
			if ((response == 'y') || (response == 'Y')) {
				next = false;
			} else {
				next = true;
			}

		} while (!next);

	}

}