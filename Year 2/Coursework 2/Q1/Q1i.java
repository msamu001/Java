import java.sql.*;
import java.util.*;
import java.io.*;

public class Q1i {
	public static void main(String[] args) {
		// MySQL settings
		String
			driver = "com.mysql.jdbc.Driver",
			url = "jdbc:mysql://igor.gold.ac.uk",
			database = "msamu001_jdbc",
			user = "msamu001",
			password = "Blaziken3",
			table = "marks_table";

		try {
			//Load the database driver
			Class.forName(driver);

			try {
				// Connects to database
				Connection db = DriverManager.getConnection(url + "/" + database, user, password);

				try {
					// Drops the table if it exists
					db.createStatement().executeUpdate("DROP TABLE " + table + "");

					// Create a table
					db.createStatement().executeUpdate("CREATE TABLE " + table + " (ID int PRIMARY KEY, Name text, YearOfStudy int, Marks int)");

					try {
						// Creates a scanner to scan through file
						Scanner file = null;
						file = new Scanner(new File("marks-input.txt"));

						// Skip past irrelivant content in file
						file.nextLine();
						file.nextLine();

						// Inserts data from file into the database
						while(file.hasNext()) {
							db.createStatement().executeUpdate("INSERT INTO " + table + "(ID, Name, YearOfStudy, Marks) VALUES ('"+ file.next() + "', '" + (file.next() + " " + file.next()) + "', '" + file.next() + "', '" + file.next() + "')");
						}
					} catch(FileNotFoundException e) { // File not found error
						System.out.println("Incorrect File Name: " + e.toString());
					}
				} catch(SQLException e) { // Data insert error
					System.err.println("Error inserting data: " + e.toString());
				}
			} catch(SQLException e) { // Database connection error
				System.err.println("Database connection error: " + e.toString());
			}
		} catch(ClassNotFoundException e) { // Driver error
			System.err.println("Driver not found: " + driver);
		}
	}
}