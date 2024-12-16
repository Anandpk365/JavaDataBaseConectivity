package Controller;

import java.util.Scanner;

import Service.Delete;
import Service.Insert;
import Service.Select;
import Service.Update;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);


		while(true) {
			System.out.println("Press 1 for Insert operation");
			System.out.println("Press 2 for Select operation");
			System.out.println("Press 3 for Update operation");
			System.out.println("Press 4 for Delete operation");
			System.out.println("Press 0 for Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: Insert.insert();
			System.out.println("Insert operation perform successfully..");
			break;
			
			case 2: Select.select();
			System.out.println("Select operation is performed Successfully..");
			break;
			
			case 3: Update.update();
			System.out.println("Update operation is performed Successfully..");
			break;
			
			case 4: Delete.delete();
			System.out.println("Delete operation is performed Successfully..");
			break;
			
			case 0 : System.out.println("System is closing..");
			System.exit(0);
			break;
			default:
				System.out.println("Please give valid inputs \n");
			}
		}

	}

}
