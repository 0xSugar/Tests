package interestingTasks.university;

import java.util.Collections;
import java.util.List;

public class University {
    private String name;

    private List<Audience> audiences;
    private List<Student> students;

    public University(String name) {
        this.name = name;
    }

    public List<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(List<Audience> audiences) {
        this.audiences = audiences;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        for (Audience audience : audiences) {
            stringBuilder.append("\t").append(audience).append('\n');
        }
        return stringBuilder.toString();
    }
}
