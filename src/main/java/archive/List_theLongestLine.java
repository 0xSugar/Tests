package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Вводятся 5 строк. Программа определяет самые длинные строки
 * и выводит их на экран. Если таких строк несколько - выводит несколько.
 *
 * В первом варианте кода я не знал, что можно получить длину списка введя strings.get(0).length();
 * потому сначала переводил строку со списка в перемнную String, а потом брал с помощью length();
 *
 * В третьем варианте я понял (google подсказал), что можно сначала отсортировать строки и взять длину
 * самой длинной строки, после чего просто сравнить все строки и вывести их. Код уменьшелся с каждым улучшением
 * и пониманием
 */




public class List_theLongestLine { // Номер 4
    private static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();                                        // создание списка
        int maxSize = Integer.MIN_VALUE;                                    // переменная самой длинной строки
        for (int i = 0; i < 5; i++) {
            strings.add(rd.readLine());                                     // циклом заносятся данные в список
            if (maxSize >= strings.get(i).length()) maxSize = strings.get(i).length();  // значение самой длинной строки
        }                                                                             // заносятся в переменную
        for (int i = 0; i < strings.size(); i++) {
            if (maxSize == strings.get(i).length())                         // если это она - вывести на экран, если нет
                System.out.println(strings.get(i));                         // то закончить код.
            else break;
        }
    }
}




//public class List_theLongestLine { // Номер 3
//    private static ArrayList<String> strings;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        strings = new ArrayList<>();                                        // создание списка
//        for (int i = 0; i < 5; i++) {                                       // циклом заносятся данные в список
//            strings.add(rd.readLine());
//        }
//        Collections.sort(strings, (s1, s2) -> s2.length() - s1.length());   // сортировка, не знвю что значит, просто выучил.. типа
//                                                                            // (имя_списка, (s1, s2) -> s2.length() - s1.length()); В гугле зовут лямбадой
//        int maxSize = strings.get(0).length();                              // Передаем самую большую строку
//        for (int i = 0; i < strings.size(); i++) {
//            if (maxSize == strings.get(i).length())                         // если это она - вывести на экран, если нет
//                System.out.println(strings.get(i));                         // то закончить код.
//            else break;
//        }
//    }
//}

/**
 * Вот он, код написан лично мной. Без гугла, без подсказок, мать его.
 */
/*public class List_theLongestLine {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList <String>();                         // создание списка
        for (int i = 0; i < 5; i++) {                               // циклом заносятся данные в список
            strings.add(rd.readLine());
        }
        getLongLine(strings);                                       // список передается методу
    }

    public static void getLongLine(ArrayList<String> strings){
        int maxAmountOfChars = 0;                                   // даем перемнной, которая будет хранить макс.
        for (int i = 0; i < strings.size(); i++) {                  // число символов в строке
            String n1 = strings.get(i);                             // Заносим строку списка в переменную String
            if (maxAmountOfChars < n1.length()) {                   // Что бы сравнить кол-во символом в строке
                maxAmountOfChars = n1.length();                     // если в строке больше символов чем в maxAmountOfChars
            }                                                       // то maxAmountOfChars приравневает новое число
        }
        for (int i = 0; i < strings.size(); i++){                   // Создаем цикл на перебор всех строк по длине
            String n1 = strings.get(i);
            if (maxAmountOfChars == n1.length()) {                  // Если в строке макс. число символов, то она
                System.out.println(n1);                             // самая большая - выводим на экран
            }
        }

    }
}
*/










