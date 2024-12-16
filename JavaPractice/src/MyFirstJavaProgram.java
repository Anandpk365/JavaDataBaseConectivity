import java.util.Scanner;

public class MyFirstJavaProgram {

	public static void main(String[] args) {
		System.out.println("Anand Kumar, Welcome to the Java full stack course");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Rows for Pattern");
		int n=sc.nextInt();
		
		System.out.println("This is the 1st pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
		 
		System.out.println("This is the 2nd pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(i+1+" ");
			}
			System.out.println();
		}
		
		System.out.println("This is the 3rd pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("This is the 4th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=n;j>0;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println("This is the 5th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<=n+i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
			
		}
		
		System.out.println("This is the 6th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(i+1+" ");
			}
			System.out.println();
		}
		
		System.out.println("This is the 7th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=i+1;j++) {
				System.out.print(j+" ");
				
			}
			System.out.println();
		}
		
		System.out.println("This is the 8th pattern");
		int ans=1;
		for(int i=0;i<n;i++) {
			
			for(int j=1;j<=i+1;j++,ans++) {
				System.out.print(ans+" ");
				
			}
			System.out.println();
		}
		
		
		System.out.println("This is the 8th pattern");
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				System.out.print((char)(65+j)+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("This is the 9th pattern");
		
		for(int i=0;i<n;i++) {
			
			for(int j=i;j<n+i;j++) {
				System.out.print((char)(65+j)+" ");
			}
			System.out.println();
		}
		
		
		
		System.out.println("This is the 10th pattern");
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				System.out.print((char)(65+j)+" ");
			}
			System.out.println();
		}
		
		System.out.println("This is the 11th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(j+1+" ");
			}
			
			for(int j=1;j<=i*2;j++) {
				System.out.print("* ");
			}
			
			for(int j=n-i;j>=1;j--) {
				System.out.print(j+" ");
			}
			
			System.out.println();
	
		}
		
		System.out.println("This is the 12th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print((char)(64+j)+" ");
			}
			
			System.out.println();
		}
		
		System.out.println("This is the 13th pattern");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(n-1-i+j+" ");
			}
			
			for(int j=0;j<n-1-i;j++) {
				System.out.print(n+" ");
			}
			System.out.println();
			
		}

		

	}

}
