package src.services;

import java.sql.*;
import src.db.DBConnection;
import src.models.Student;

public class StudentService {
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(id, name, department, section) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDepartment());
            stmt.setString(4, student.getSection());

            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
