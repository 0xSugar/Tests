package interestingTasks.university;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Университет
 * У университета есть аудитории, за аудиторией может быть закреплены преподаватели (1 или больше) у преподавателя
 *      могу быть ученики до 30. Один преподаватель преподаёт один предмет.
 * Задача:
 * Рандомно наполнить университет аудиториями, учителями и учениками. Вывести на консоль:
 * - аудиторию и какие преподаватели за ней закреплены
 * - преподавателя и какие ученики за ним закреплены
 * - учеников, у которых больше 6-и преподавателей
 * Дополнительно: продержатся реальности. Например, у ученика не должно быть слишком много преподов и не должно быть
 *      разных преподов по одному предмету или на оборот у ученика не должен быть всего один препод или не быть вообще
 *      и т.п.
 *
 * ================================================================================
 * ================================================================================
 * Что бы у каждого учителя было от 10 до 30 учеников - нужно в методе createStudents в цикле
 * убрать деление на колличество учителей. Это сделано, что бы лучше видеть результат...
 */

public class Main {
    private static final SplittableRandom RANDOM = new SplittableRandom();
    private static final int MIN_AMOUNT_OF_STUDENTS = 10;
    private static final int MAX_AMOUNT_OF_STUDENTS = 30;
    private static final int MAX_AMOUNT_OF_AUDIENCES = 10;

    private static University university;

    public static void main(String[] args) {
        university = new University("Ужасный университет");
        university.setAudiences(createAudiencesAndTeachers());
        university.setStudents(createStudents(university));

        System.out.println("Вся статистика:");
        System.out.println(university);
        System.out.println("==================================");

        System.out.println("Ученики, у которых больше 6ти преподов");
        printResult(university);
    }

    private static void printResult(University university) {
        for (Student student : university.getStudents()) {
            if (student.getTeacherList().size() > 6) {
                System.out.println(student);
            }
        }
    }

    private static List<Student> createStudents(University university) {
        List<Student> students = new ArrayList<>();
        // берем аудиторию
        for (Audience audience : university.getAudiences()) {
            // и считаем, сколько там должно быть студентов всего (рандомно)
            int count = audience.getTeachers().size() * RANDOM.nextInt(MIN_AMOUNT_OF_STUDENTS, MAX_AMOUNT_OF_STUDENTS);

            // делим что бы лучше было видно результат
            count /= audience.getTeachers().size(); // <- это можно убрать

            for (int i = 0; i < count; i++) {                   // проходим по всем ученикам
                Student student = new Student("Student_" + i, audience);    // создаем
                students.add(student);                                            // добавляем в лист студетов
                for (Teacher teacher : audience.getTeachers()) {            // проходим по учителям
                    if (RANDOM.nextInt(0, 10) >= 7) {          // с каким-то шансом
                        student.addTeacher(teacher);    // добавляем студенту этого учителя
                        teacher.addStudent(student);    // и учителю - этого студента
                    }
                }
            }
        }
        return students;
    }

    private static List<Audience> createAudiencesAndTeachers() {
        List<Audience> audiences = new ArrayList<>();
        int numberOfAudiences = RANDOM.nextInt(4, MAX_AMOUNT_OF_AUDIENCES);

        for (int i = 0; i < numberOfAudiences; i++) {
            Audience audience = new Audience("Audience " + i);
            audience.setTeachers(createTeachers(i));
            audiences.add(audience);
        }
        return audiences;
    }

    private static List<Teacher> createTeachers(int numb) {
        List<Teacher> teachers = new ArrayList<>();

        List<String> subjects = new ArrayList<>(Util.getSubjects());
        int numberOfTeachers = RANDOM.nextInt(6, subjects.size());

        for (int i = 0; i < numberOfTeachers; i++) {
            int index = RANDOM.nextInt(100) % subjects.size();
            teachers.add(new Teacher((numb + "_Teacher " + i), subjects.get(index)));
            subjects.remove(index);
        }
        return teachers;
    }
}
