package src.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import src.db.DBConnection;
import src.models.Subject;

public class addSubjects {
	public void addSubject(Subject subject){
		String sql="INSERT INTO SUBJECT(subjectID,subject)values (?,?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement stmt=con.prepareStatement(sql);){
					stmt.setInt(1,subject.getId());
					stmt.setString(2, subject.getName());
					stmt.executeUpdate();
					System.out.println("Subject added successfully!");
				}
		catch(Exception e) {
			System.out.print("e.toString()");
		}
				
	}
}
