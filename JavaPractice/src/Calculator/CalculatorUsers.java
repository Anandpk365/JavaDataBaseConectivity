package Calculator;

import java.util.Scanner;

public class CalculatorUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	    int a,b;
		
			
		while(true) {
			
			System.out.println("Please Select your Choice");
			
			char operator=sc.next().charAt(0);
			System.out.println("Enter two number");
		    a=sc.nextInt();
		    b=sc.nextInt();
		    Calculator clc= new Calculator(a,b);

			
		switch(operator) {
		case '+':
			System.out.println(clc.addition());
			break;
			
		case '-':
			System.out.println(clc.subs());
			break;
		case '*':
			System.out.println(clc.mult());
			break;
		case '/':
			try {
				System.out.println(clc.division());
	
			}catch(UserDefinedException e){
				
				System.out.print("Entered denominator number is 0, Please give valid number");
				
			}
			break;
			
		case '%':
			System.out.println(clc.mod());
			break;
		default :
			System.out.println("Please enter the valid Operation for the execution");
		}
		}
		

	}

}
