package Recursion;

public class ReverseNum {

	public static void main(String[] args) {
		System.out.print(reverseNum(12345));

	}

	public static int reverseNum(int n) {
		if (n == 0) {
			return 0;
		}
		
		int rem = 10*(n%10);

		return  + reverseNum(n / 10);
	}

}
