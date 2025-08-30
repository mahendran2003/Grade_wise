package src.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.db.DBConnection;
import src.models.Grade;

public class GradeService {
    public void addGrade(Grade grade) {
        String sql = "INSERT INTO grade(studentID, subjectID, marks, grade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, grade.getStudentId());
            stmt.setInt(2, grade.getSubjectId());
            stmt.setInt(3, grade.getMarks());
            stmt.setString(4, grade.getGrade());
            stmt.executeUpdate();
            System.out.println("Grade added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
