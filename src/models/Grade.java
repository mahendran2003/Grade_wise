package src.models;

public class Grade {
     private int studentId;
    private int subjectId;
    private int marks;
    private String grade;

    public Grade(int studentId, int subjectId, int marks, String grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
        this.grade = grade;
    }

    public int getStudentId() { return studentId; }
    public int getSubjectId() { return subjectId; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }
}
