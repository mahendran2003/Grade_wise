package src.models;

public class Student {
        private int id;
    private String name;
    private String department;
    private String section;

    public Student(int id, String name, String department, String section) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.section = section;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getSection() { return section;}
}
