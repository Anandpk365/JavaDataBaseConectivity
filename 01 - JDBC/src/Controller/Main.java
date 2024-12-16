package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import Operation.DeleteOp;
import Operation.InsertOp;
import Operation.SelectOp;
import Operation.UpdateOp;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please select the Manu: ");
			System.out.println("1 : Select ");
			System.out.println("2 : Insert ");
			System.out.println("3 : Delete");
			System.out.println("4 : Update");
			System.out.println("0 : Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				SelectOp.select();
				System.out.println("Select Operation is performed ...\n");
				break;
			case 2:
				InsertOp.insert();
				System.out.println("Insert Operation is performed ...\n");
				break;
			case 3:
				DeleteOp.delete();
				System.out.println("Delete Operation is performed ...\n");
				break;
			case 4:
				UpdateOp.update();
				System.out.println("Update Operation is performed ...\n");
				break;
			case 0:
				System.out.println("System is closing");
				System.exit(0);
			default:
				System.out.println("You have selected wrong menu.. Please select once again!");

			}
		}
	}

}
