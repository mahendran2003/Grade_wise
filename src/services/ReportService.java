package src.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.db.DBConnection;

public class ReportService {

    public void showGradesForStudent(int studentId) {  // ✅ Accept studentId
        String sql = "SELECT s.name, sub.subject, g.marks, g.grade " +
                     "FROM grade g " +
                     "JOIN students s ON g.studentID = s.id " +
                     "JOIN subject sub ON g.subjectID = sub.subjectID " +
                     "WHERE s.id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId); // ✅ Set the parameter
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- Grades for Student ID: " + studentId + " ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%s | %s | %d | %s\n",
                    rs.getString("name"),
                    rs.getString("subject"),
                    rs.getInt("marks"),
                    rs.getString("grade"));
            }

            if (!found) {
                System.out.println("No grades found for this student.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

	
}
