package DateOperation;

public class DateOp {
	
	public static void main(String[] arg) {
		java.util.Date uDate = new java.util.Date();
		System.out.println("Date with time : "+uDate);
		
		long value = uDate.getTime();
		java.sql.Date date = new java.sql.Date(value);
		
		System.out.println("Date : "+date);
	}

}
