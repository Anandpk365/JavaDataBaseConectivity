package DateOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConversionDateFormat {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the date (dd-mm-yyyy) : ");
		String ssDate =sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate =sdf.parse(ssDate);
		
		long value = uDate.getTime();
		
		java.sql.Date sDate = new java.sql.Date(value);
		
		System.out.println("String format date : "+ssDate);
		System.out.println("Util format date : "+uDate);
		System.out.println("SQL format date : "+sDate);
		
		
		System.out.println("Enter the following DOM date (yyyy-MM-dd) : ");
		String date = sc.next();
		
		java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		
		System.out.println("Date : "+date);
		System.out.println("SQL date : "+sqlDate);
		

	}

}
