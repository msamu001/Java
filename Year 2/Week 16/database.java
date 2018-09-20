import java.sql.*;
import java.util.*;
import java.io.*;

public class database {
	public static void main(String[] args) {
		// MySQL settings
		String
			driver = "com.mysql.jdbc.Driver",
			url = "jdbc:mysql://igor.gold.ac.uk",
			database = "msamu001_jdbc",
			user = "msamu001",
			password = "Blaziken3",
			table = "marks_table";

		// To store data from text file
		ArrayList<String> ids  = new ArrayList<>();
		ArrayList<String> name  = new ArrayList<>();
		ArrayList<String> yos  = new ArrayList<>();
		ArrayList<String> marks = new ArrayList<>();

		try {
			Scanner file = null;
			//Scanner input = new Scanner(System.in);
			//String fileName = input.next().trim();
			file = new Scanner(new File("marks-input.txt"));

			// Skip first two lines
			file.nextLine();
			file.nextLine();
		
			while(file.hasNext()) {
				ids.add(file.next());
				name.add(file.next() + " " + file.next());
				yos.add(file.next());
				marks.add(file.next());
			}
		} catch(FileNotFoundException e) {
			System.out.println("Incorrect File Name: " + e.toString());
		}

		try {
			//Load the database driver
			Class.forName(driver);

			try {
				// Get a database connection
				Connection db = DriverManager.getConnection(url + "/" + database, user, password);

				try {
					//db.createStatement().executeUpdate("DROP TABLE " + table + "");
					// Create a table
					db.createStatement().executeUpdate("CREATE TABLE " + table + " (ID int PRIMARY KEY, Name text, YearOfStudy int, Marks int)");

					// Insert a row
					for(int i = 0; i < ids.size(); i++) {
						db.createStatement().executeUpdate("INSERT INTO " + table + "(ID, Name, YearOfStudy, Marks) VALUES ('"+ ids.get(i) + "', '" + name.get(i) + "', '" + yos.get(i) + "', '" + marks.get(i) + "')");
					}
				} catch(SQLException e) { // Data insert error
					System.err.println("Error inserting data: " + e.toString());
				}
			} catch(SQLException e) { // Database connection error
				System.err.println("");
			}
		} catch(ClassNotFoundException e) { // Driver error
			System.err.println("Driver not found: " + driver);
		}
	}
}