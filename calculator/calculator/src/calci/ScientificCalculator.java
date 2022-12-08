package calci;

import java.io.*;
import java.util.Scanner;

import calci.calculate;

public class ScientificCalculator extends calculate
{
	char Operator;
	Double dblNumber = new Double(0);

	ScientificCalculator() {     
	}

	ScientificCalculator(double dblNumber, char Operator) {

		super(dblNumber, Operator);

		this.Operator = Operator;
		this.dblNumber = dblNumber;
	}

	public void Calc() throws java.io.IOException {
		boolean next;

		do {
			Double d = new Double(0);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

			// Gets User Input
			System.out.println(
					"Please enter the Operation (Sine-s, Cosine-c, Tangent-t, NaturalLog-z,Logarithm-l");
			System.out.println(	 " SquareRoot-r, NthPower-n, InverseCos-i, InverseSin-j, InverseTan-k, decimaltobinary-d");
			System.out.println(	" binarytodecimal-b, fiv-1,  ):");
			System.out.flush();
			String option = buffer.readLine(); 

			System.out.println("Please enter a Value: ");

			System.out.flush();
			try {
				d = Double.valueOf(buffer.readLine());
			} catch (NumberFormatException e) {
				System.out.println("*///*Please provide numeric values.*///*");
				System.exit(0);
			}

			if (option.length() == 1) {

				// Creates Class Instance
				ScientificCalculator sc = new ScientificCalculator(d, option.charAt(0));

				sc.doCalculation(); // Calls Super Class Methods
				sc.getResult(); // Calls Super Class Methods
			} else {
				System.out.println("*///*Operation Not Available. Please select any of the available options.*///*");
			}

			System.out.println("Would you like to calculate again (y/n)?");
			System.out.println("");
			System.out.println("ShowpreviousCalculation: p");      //to show the previous calculation done by user
			System.out.println("");
			System.out.println("Store for later use" + "(s)");
			System.out.flush();
			char aa = (char) buffer.read();
			if ((aa == 'y') || (aa == 'Y')) {
				System.out.println("your saved memo is");
				File file = new File("History.txt");         
				BufferedReader br = new BufferedReader(new FileReader(file));
				String abc = br.readLine();
				System.out.println(abc);
				next = false;

			} else if (aa == 'p') {
				File file = new File("calculator.txt");     //previous calculation
				BufferedReader br = new BufferedReader(new FileReader(file));
				String abc = br.readLine();
				System.out.println(abc);
				next = false;
			} else if (aa == 's') {     //if want to add from existing then
				System.out.println("do you want to add previous one or your own?");
				System.out.println("previous :::p");
				System.out.println("your own:::o");
				Scanner sc = new Scanner(System.in);
				String mc = sc.next();
				if (mc.equals("p")) {
					File file = new File("calculationHistory.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					String memo1 = br.readLine();
					FileWriter fw = new FileWriter("History.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(memo1);
					bw.close();
					System.out.println("success!!");
				} else {
					System.out.println("add number of your choice.");
					String mc2 = sc.next();
					String memo2 = mc2;
					FileWriter fw = new FileWriter("History.txt"); 
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(memo2);
					bw.close();
					System.out.println("success!!");
				}
				next = false;
			} else {
				next = true;
			}

		} while (!next);
	}

	public void doCalculation() {
		// TODO Auto-generated method stub
		
	}

	public void getResult() {
		// TODO Auto-generated method stub
		
	}

}