import java.util.Scanner;

class UserException extends Exception{
	UserException(String msg){
		super(msg);
	}
}

class Bank{
	int user=1234;
	int pws=1111;
	int usid;
	int pass;
	
	void get(int usr, int p) {
		usid=usr;
		pass=p;
	}
	
	void verify(int usr, int p) throws UserException {
		if(usr==user && p==pws) {
			System.out.println("Login Success");
		}else {
			UserException ue=new UserException("Invalid input");
			
			System.out.println(ue.getStackTrace());
			
			throw ue;
		}
	}
}
public class TryCatchExceptionHandling {
	

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			
			try {
			int user=sc.nextInt();
			int pws=sc.nextInt();
			
			Bank b = new Bank();
			
			b.get(user, pws);
			
			}catch(Exception ue) {
				System.out.println(ue.toString());
			}
			
			System.out.print("Terminated Success");
//		
//		System.out.println("Eneter ther numer");
//		
//		try {
//		int num1=sc.nextInt();
//		int num2=sc.nextInt();
//		System.out.println(num1/num2+"->result");
//		}catch(Exception e) {
//			
//			System.out.println(e.toString());
//			
//		}
//		
		sc.close();
	
	}

}
