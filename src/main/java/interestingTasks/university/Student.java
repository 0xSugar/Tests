package interestingTasks.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Human {
    private Audience audience;
    private List<Teacher> teacherList = new ArrayList<>();

    public Student(String name, Audience audience) {
        super(name);
        this.audience = audience;
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public Audience getAudience() {
        return audience;
    }

    public List<Teacher> getTeacherList() {
        return Collections.unmodifiableList(teacherList);
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}
