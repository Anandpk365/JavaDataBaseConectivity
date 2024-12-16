import java.util.Scanner;

public class LinkedListUser {
	
    public static Node head = null;
	
	public static Node createLinkedList() {
		
		Scanner sc= new Scanner(System.in);
		
		int data = sc.nextInt();
		
//		Node head = null;
		
		while(data !=-1) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
			}else {
				Node temp = new Node(data);
				while(temp.next!=null) {
					temp=temp.next;
				}
				
				temp.next = newNode;
				
			}
			data=sc.nextInt();
		}
	return head;

	}
	

	
	public static void displayLinkedList() {
		Node temp= head;
		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
//		if(temp==null) {
//			System.out.println("Node is not Created Yet..");
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {

		System.out.println("Choices : \n1st : Create new Node\n2ne : Dispaly\n0 : Exit");
		System.out.println("Enter the choice from the user:\n ");
		int choice = sc.nextInt();	
		Node newNode = null;
		switch(choice) {
		case 1: newNode= createLinkedList();
		        System.out.println("NewNode Successfully Created...");
		        break;
		        
		case 2: System.out.println("Below are the data which is in LinkedList...");
			    displayLinkedList();
		        break;
		case 0 : System.exit(0);
		}
		System.out.println();

		}

	}

}
