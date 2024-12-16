package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuCards {
	
	public static void menuCard() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Select the option from the below: \n");
			System.out.println("Press 1 for the InserOperation");
			System.out.println("Press 2 for the SelectOperation");
			System.out.println("Press 3 for the UpdateOperation");
			System.out.println("Press 4 for the DeleteOperation");
			System.out.println("Press 5 for the DisplayALL records");
			System.out.println("Press 6 for getting the total records count");
			System.out.println("Press 7 for the Exit");
			
			System.out.println("Please select one of the above number: ");
			int choice = sc.nextInt();
			
			try {
			switch(choice) {
			
			case 1: System.out.println("Congragulation You have pressed 1 ");
			        System.out.println("Please enter the ID : ");
			        int id = sc.nextInt();
			        
			        System.out.println("Enter the Name : ");
			        String name = sc.next();
			        
			        System.out.println("Enter the DOJ (yyyy-MM-dd) : ");
			        String doj = sc.next();
			        
			        System.out.println("Enter the DOE (yyyy-MM-dd) : ");
			        String doe = sc.next();
			        
			        System.out.println("Please give the image Location : ");
			        String image = sc.next();
			        
			        System.out.println("Please give the PDF location : ");
			        String pdf = sc.next();
			        
			        InsertOperation.insert(id, name, doj, doe, image, pdf);
			        break;
				
			case 2: System.out.println("Congragulation You have pressed 2 ");
				    System.out.println("Please enter the ID number");
	                int sID = sc.nextInt();
	                SelectOperation.select(sID);
		            break;
				
			case 3: System.out.println("Congragulation You have pressed 3 ");
		            System.out.println("Please enter the ID number");
                    int ID = sc.nextInt();
                    System.out.println("Enter the name for uodate : ");
                    String name1 = sc.next();
                    
                    UpdateOperation.update(ID, name1);
                    break;
				
			case 4: System.out.println("Congragulation You have pressed 4 ");
                    System.out.println("Please enter the ID number");
                    int id1 = sc.nextInt();
                    
                    DeleteOperation.delete(id1);
                    break;
                    
			case 5: System.out.println("Congragulation You have pressed 5 ");
			        DisplayAllRecords.display();
			        break;
			        
			case 6: System.out.println("Congragulation You have pressed 5 ");
			        int rowCount = TotallNumberRecords.totalNumberRecords();
			        System.out.println("Total records : "+rowCount);
			        break;
			
			case 7: System.out.println("Congragulation You have pressed 6.. \nNow System will closed");
			        System.exit(0);
			        break;
			        
				
			default: System.out.println("Invalid Pressed number ");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	}

	
}
