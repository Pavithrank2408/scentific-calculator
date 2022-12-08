package calci;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class calculate implements calci1 { 
	private char Operator;
	private int FNum, SNum;
	private Double dblNumber = new Double(0);
	private Double dblResult = new Double(0);
	private int Result = 0;
	private boolean typeDouble = false;
	private boolean typeInt = false;

	public calculate() {
	}

	public calculate(Double dblNum, char cOperator) {
		dblNumber = dblNum;
		Operator = cOperator;
		typeDouble = true;
	}

	public calculate(int FirstNum, char cOperator, int SecondNum) { 
		FNum = FirstNum;
		SNum = SecondNum;
		Operator = cOperator;
		typeInt = true;

	}

	public void doCalculation() { // Calculates the Result based on the operator selected by the user
		File file = new File("calculationhistory.txt");     //text file to save current history 
		file.deleteOnExit();   //this file is just for that calculation history after this it will delete automatically

		try {
			FileWriter fw = new FileWriter(file);              //this is saving history
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			Result = 0;
			dblResult = 0.0;

			switch (Operator) {

			case '+':
				checkInt();

				Result = FNum + SNum;

				fw.append(FNum + "" + Operator + "" + SNum + "=" + Result);

				fw.close();
				break;

			case '-':

				checkInt();
				Result = FNum - SNum;
				bw.newLine();
				fw.append(FNum + "" + Operator + "" + SNum + "=" + Result);
				fw.close();
				break;

			case '*': 
				checkInt();
				Result = FNum * SNum;
				bw.newLine();
				fw.write(FNum + "" + Operator + "" + SNum + "=" + Result);
				fw.close();
				break;

			case '/': // case for division
				checkInt();
				if (!checkSecondNum()) {
					Result = FNum / SNum;
					bw.newLine();
					fw.write(FNum + "" + Operator + "" + SNum + "=" + Result);
					fw.close();
					break;
				}

			case 'S': 
			case 's':
				checkDouble();
				dblResult = Math.sin(dblNumber);
				fw.write("Sin" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();

				break;

			case 'C': 
			case 'c':
				checkDouble();
				dblResult = Math.cos(dblNumber);
				fw.write("Cos" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;

			case 'T': 
			case 't':
				checkDouble();
				dblResult = Math.tan(dblNumber);
				fw.write("Tan" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;

			case 'L':
			case 'l':
				checkDouble();
				dblResult = Math.log(dblNumber);
				fw.write("Log" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'z':
			case 'Z':
				checkDouble();
				dblResult = Math.log(dblNumber);

				break;
			case 'r': 
			case 'R':
				checkDouble();
				dblResult = Math.sqrt(dblNumber);
				fw.write("Sqrt" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'i':
			case 'I': 
				checkDouble();
				dblResult = Math.acos(dblNumber);
				fw.write("ICos" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'j': 
			case 'J':
				checkDouble();
				dblResult = Math.asin(dblNumber);
				fw.write("ISin" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'k':
			case 'K':
				checkDouble();
				dblResult = Math.atan(dblNumber);
				fw.write("ITan" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'n': 
			case 'N':
				Scanner sc = new Scanner(System.in);
				int nrt;
				System.out.println("enter the number which you want power for ");
				nrt = sc.nextInt();
				checkDouble();
				dblResult = (double) Math.round(Math.pow(dblNumber, nrt));
				fw.write(nrt + "" + "root of" + "" + dblNumber + "" + "" + "=" + dblResult);
				fw.close();
				break;
			case 'd':
			case 'D':

				Scanner sc1 = new Scanner(System.in);
				int dn;
				System.out.println("enter the number to convert into binary ");
				dn = sc1.nextInt();
				System.out.println("Binary representation of  " + dn);
				String qwe = Integer.toBinaryString(dn);
				System.out.println(Integer.toBinaryString(dn));
				fw.write("binary rep of " + "" + dn + "" + "" + "=" + qwe);
				fw.close();
				break;
			case '1': 
				Scanner sc11 = new Scanner(System.in);

				System.out.print("Enter present value: ");
				double p = sc11.nextInt();
				System.out.print("Enter the interest rate: ");
				double r = sc11.nextInt();
				System.out.print("Enter the time period in years: ");
				double y = sc11.nextInt();
				double f = p * Math.pow((1 + r / 100), y);
				System.out.print("value is: " + f);
				bw.close();
				break;
			case 'b':  
			case 'B':
				System.out.println("Please enter a binary string: ");
				Scanner sc2 = new Scanner(System.in);
				String b2d = sc2.nextLine();
				System.out.println("the decimal number is " + Integer.parseInt(b2d, 2));
				break;
			default:
				Result = 0;
				dblResult = 0.0;
				System.out.println("*///*Operation Not Available. Please select any of the available options.*///*");
				break;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//display the result of calculations as an output
	public void getResult() {
		if (typeInt) {
			System.out.println("The result is: " + Result);
		} else if (typeDouble) {
			System.out.println("The result is: " + dblResult);
		}
	}

//checks for zero
	public boolean checkSecondNum() {
		if (SNum == 0) {
			System.out.println("Zero Not allowed");
			System.exit(0);
			return true;
		} else {
			return false;
		}
	}

	public void checkInt() {                    //checking if number type is integer
		if (!typeInt) {
			Result = 0;
			System.out.println("*///*Operation Not Available. Please select any of the available options.*///*");
			System.exit(0);
		}
	}

	public void checkDouble() {                //checking if number type is float 
		if (!typeDouble) {
			dblResult = 0.0;
			System.out.println("*///*Operation Not Available. Please select any of the available options.*///*");
			System.exit(0);
		}
	}

	public void showHistory() {

	}

}