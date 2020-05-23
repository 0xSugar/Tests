package interestingTasks.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
    private static List<String> subjects = new ArrayList<>();

    static {
        Collections.addAll(subjects, "Математика", "Физкультура", "История", "Литература", "ОБЖ",
                "Технология", "География", "Биология", "Информатика", "Обществознание", "Черчение", "Алгебра",
                "Геометрия", "Физика", "Химия", "Основы экономики", "Философия", "Экология", "Астрономия");
    }

    public static List<String> getSubjects() {
        return subjects;
    }
}
