package interestingTasks.university;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human {
    private String subject;
    List<Student> students;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" (").append(subject).append(")").append('\n');
        for (Student student : students) {
            stringBuilder.append("\t\t\t").append(student).append("\n");
        }
        return stringBuilder.toString();
    }
}
