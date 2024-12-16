package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Util.Jdbc;

public class Select {

	private static Connection connection;
	private static PreparedStatement pstmt;
	private static String quary;
	private static ResultSet resultSet;

	public static void select() {

		Scanner sc = new Scanner(System.in);

		connection = Jdbc.getConnection();

		quary = "Select * from employee where id = ?";

		try {
			if (connection != null) {
				pstmt = connection.prepareStatement(quary);
			}

			System.out.println("Enter the ID");
			int id = sc.nextInt();

			pstmt.setInt(1, id);

			resultSet = pstmt.executeQuery();

			if (resultSet != null) {
				System.out.println("ID\t\tName\t\tSalary");

				while (resultSet.next()) {
					System.out.println(
							resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getFloat(3));
				}
			} else {
				System.out.println("ID's Employee is not Available...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.clean(connection, pstmt, resultSet);
		}
	}

}
