package readers;

import java.io.*;
import java.util.ArrayList;

/**
 * Задача с JavaRush, условия:
 *
 * 1. Ввести с консоли имя файла.
 * 2. Найти байт или байты с максимальным количеством повторов.
 * 3. Вывести их на экран через пробел.
 * 4. Закрыть поток ввода-вывода.
 *
 * P.S.: Простой вариант решения ниже, на минимум
 */
public class S8_Show_TheSame_Bytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList<>();

        while (fis.available() > 0) {
            int k = fis.read();
            list.add(k);                    // добавляем в лист все байты
            System.out.println(k);                                              // вывод для меня ^ ^
        }
        fis.close();                        // закрываем поток

        System.out.println("---- - - -- - ---- -- -");                          // тоже для меня
        int count = 0;                          // объявляем переменные и лист, где будут находится наши id
        ArrayList<Integer> listID = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {       // перебор чисел листа по его же числам
            int tmp = 0;                                // объявляем + обнуляем переменную

            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {  // если цифры одинаковые (байты) - увеличить tmp
                    tmp++;
                }
            }

            if (count < tmp) {          // если наш count < tmp
                listID.clear();         // очистить лист (т.к. мне нужны числа, что повтоярются больше всего)
                count = tmp;            // взять число больше всего повторяющихся значений
                listID.add(i);          // добавить этот байт в лист
            } else if (count == tmp) {  // если count = tmp (т.е. если повторяется столько же раз)
                listID.add(i);          // просто добавить в лсит
            }
        }

        listID.forEach(x -> System.out.print(list.get(x) + " "));

    }
}

/**
 * Более простой вариант
 * public static void main(String[] args) throws Exception {
 *     // считывае имя файла
 *     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 *     String file = reader.readLine();
 *     reader.close();
 *
 *     FileInputStream fis = new FileInputStream(file);
 *     int[] allBytes = new int[256];
 *
 *     // заносим все в массив
 *     while (fis.available() > 0) {
 *         int k = fis.read();
 *         allBytes[k]++;
 *         System.out.println(k);
 *     }
 *     fis.close();
 *     System.out.println("---- ==== ---- ===== -=- =- -=-=");
 *
 *     // находим минимальное значение в массиве
 *     int min = Integer.MAX_VALUE;
 *     for (int a : allBytes) {
 *         if (a < min && a != 0) {
 *             min = a;
 *         }
 *     }
 *
 *     // выводим
 *     for (int i = 0; i < 256; i++) {
 *         if (min == allBytes[i]) {
 *             System.out.print(i + " ");
 *         }
 *     }
 * }
 */

/* Вывод цифр без повторов
заменить:                                                   на:
ArrayList<Integer> listID = new ArrayList<>();              LinkedHashSet<Integer> listID = new LinkedHashSet<>();
listID.add(i);                                              listID.add(list.get(i));
listID.forEach(x -> System.out.print(list.get(x) + " "));   listID.forEach(x -> System.out.print(x + " "));
 */ // Вывод цифр без повторов

/*  Для одного повторяющегося байта
public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList<>();

        while (fis.available() > 0) {
            int k = fis.read();
            list.add(k);
            System.out.println(k);
        }
        fis.close();

        System.out.println("---- - - -- - ---- -- -");
        int count = 0, id = 0;

        for (int i = 0; i < list.size(); i++) {
            int tmp = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    tmp++;
                }
            }

            if (count < tmp) {
                count = tmp;
                id = i;
            }
        }

        int okay = id;
        listID.forEach(x -> System.out.print(list.get(x) + " "));
    }
*/ // Для одного повторяющегося байта