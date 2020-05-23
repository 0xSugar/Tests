package interestingTasks.university;

import java.util.List;

public class Audience {
    private String name;
    private List<Teacher> teachers;

    public Audience(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append('\n');
        for (Teacher teacher : teachers) {
            stringBuilder.append("\t\t").append(teacher).append("\n");
        }
        return stringBuilder.toString();
    }
}
