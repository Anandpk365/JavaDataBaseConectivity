package Calculator;

public class Calculator {
	
	private int num1;
	private int num2;
	
	public Calculator(int num1, int num2) {
		this.num1=num1;
		this.num2=num2;
	}
	
	public int addition() {
		return num1+num2;
	}
	
	public int subs() {
		return num1>num2?num1-num2: num2-num1;
	}
	
	public int mult() {
		return num1*num2;
		
	}
	
	public int division() throws UserDefinedException {
		if(num2==0)
			throw new UserDefinedException();
		
		return num1/num2;
	}
	
	
	public int mod() {
		return num1%num2;
	}
//	public setter(int num1, int num2) {
//		this.num1=num1;
//		this.num2=num2;
//	}
	
	

}
