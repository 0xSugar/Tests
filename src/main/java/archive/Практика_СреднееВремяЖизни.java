package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Практика_СреднееВремяЖизни {

    private static final long TO_DAYS = 1000L * 60 * 60 * 24;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите свой пол: ");
        boolean sex = checkSEX();
        System.out.print("\nВведите свой возраст: ");
        int age = checkAge(); // баг если Ж:70 или М:60, нужно дописать код.

        easyRes(sex, age);
        diffRes(sex, age);
    }


    /** Считывает пол и проверяет */
    private static boolean checkSEX() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean sex;
        while (true) {
            String sexline = reader.readLine();
            sexline = sexline.toUpperCase();
            if (sexline.charAt(0) == 'M' || sexline.charAt(0) == 'М' || sexline.equals("МУЖСКОЙ") || sexline.equals("МУЖ") || sexline.equals("MAN")) {
                sex = true;
                break;
            } else if (sexline.charAt(0) == 'Ж' || sexline.charAt(0) == 'W' || sexline.equals("ЖЕНСКИЙ") || sexline.equals("ЖЕН") || sexline.equals("WOMAN")) {
                sex = false;
                break;
            } else {
                System.out.print("\nОишбка. Введите ваш пол: ");
            }
        }
        return sex;
    }

    /** Считывает возраст и проверяет */
    private static int checkAge() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ageline;                     // объявили 2 переменные
        int x;
        while (true) {                      // зашли в цикл
            ageline =  reader.readLine();   // считали строку
            while (true) {                  // еще 1 цикл
                if (isNumeric(ageline)) break;  // если строка это число - выйти из цикла
                System.out.println("Ошибка. Введите ваш возраст (число): ");
                ageline =  reader.readLine();   // если нет - считать снова пока не будет число
            }
            x = Integer.parseInt(ageline);      // перевести в число
            if (x > 0 && x < 100) {             // если число больше 0 и меньше 100 - вернуть его
                return x;                       // если нет - все заново
            } else System.out.println("Введите действительный возраст: ");
        }
    }

    /** Проверка на число ли */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /** Простой подсчет  */
    private static void easyRes(boolean sex, int age) {
        if (sex) {  // М
            // простой
            if (age < 60) {
                System.out.println("Осталось жить: " + ((60-age) * 365) + " дней. (простой подсчет)");
            }
            else {
                System.out.println("Вы и так уже прожили на " + ((age-60) * 365) + " дней больше! (простой подсчет)");
            }
        } else {    // Ж
            // простой
            if (age < 70) {
                System.out.println("Осталось жить: " + ((70-age) * 365) + " дней. (простой подсчет)");
            }
            else {
                System.out.println("Вы и так уже прожили на " + ((age - 70) * 365) + " дней больше! (простой подсчет)");
            }
        }
    }

    /** Сложный подсчет  */
    private static void diffRes (boolean sex, int age) {
        Calendar calendar = new GregorianCalendar();
        Calendar dateOfDeath = new GregorianCalendar();
        long leftTime;

        if (sex) {  // М
            if (age < 60) {
                int death = 60 - age;
                dateOfDeath.add(Calendar.YEAR, death);
                leftTime = dateOfDeath.getTimeInMillis() - calendar.getTimeInMillis();
                System.out.println("Осталось жить: " + (leftTime / TO_DAYS) + " дней. (сложный подсчет)");
            } else {
                int overlived = age + 60;
                calendar.add(Calendar.YEAR, 60);
                dateOfDeath.add(Calendar.YEAR, overlived);
                leftTime = dateOfDeath.getTimeInMillis() - calendar.getTimeInMillis();
                System.out.println("Вы и так уже прожили на " + (leftTime*TO_DAYS) + " дней больше! (сложный подсчет)");
            }
        } else {    // Ж
            if (age < 70) {
                int death = 70 - age;
                dateOfDeath.add(Calendar.YEAR, death);
                leftTime = dateOfDeath.getTimeInMillis() - calendar.getTimeInMillis();
                System.out.println("Осталось жить: " + (leftTime / TO_DAYS) + " дней. (сложный подсчет)");
            } else {
                int overlived = age + 70;
                calendar.add(Calendar.YEAR, 60);
                dateOfDeath.add(Calendar.YEAR, overlived);
                leftTime = dateOfDeath.getTimeInMillis() - calendar.getTimeInMillis();
                System.out.println("Вы и так уже прожили на " + (leftTime*TO_DAYS) + " дней больше! (сложный подсчет)");
            }
        }
    }
}
