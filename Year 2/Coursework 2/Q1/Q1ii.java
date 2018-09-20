import java.sql.*;
import java.util.*;
import java.io.*;

public class Q1ii {
	public static void main(String[] args) {
		PrintWriter output = null; // Initializes PrintWriter
		try {
			output = new PrintWriter(new FileWriter("marks-output.txt", false)); // Names output file
		} catch (IOException e) {
			System.err.println(e.toString());
		}

		// Fills out first 2 lines of the results
		String results =("ID"+"\t"+ "|" +"     "+"Name"+"\t"+ "|" +" "+"Year of Study"+" "+ "|" +" "+"Mark"+"\n"+
						 "----------------------------------------------"+"\n");

		// MySQL settings
		String
			driver = "com.mysql.jdbc.Driver",
			url = "jdbc:mysql://igor.gold.ac.uk",
			database = "msamu001_jdbc",
			user = "msamu001",
			password = "Blaziken3",
			table = "marks_table";

		try {
			// Connects to database
			Connection db = DriverManager.getConnection(url + "/" + database, user, password);

			// Retrieves data from table
			ResultSet rs = db.createStatement().executeQuery("Select * from marks_table");

			while (rs.next()) { // Each result has formatting
				results += rs.getString("ID")+"\t"+"|"; // Adds ID from database to results
				String temp = rs.getString("Name"); // Adds Name from databse to temp string
				if(temp.length() < 6) // Changes size of name for formatting
					temp += "\t";
				results += " "+temp+"\t"+"|"; // Adds Name to results
				results += "\t"+rs.getString("YearOfStudy")+"\t"+"|"; // Adds YearOfStudy from databse to results
				results += "  "+rs.getString("Marks")+"\n"; // Adds  from databse to results
			}
			output.print(results); // Adds results to the output file
			output.close(); // Updates and closes the output file
			db.close(); // Close database
		} catch (Exception e) {
            System.out.println(e.toString());
        }
	}
}