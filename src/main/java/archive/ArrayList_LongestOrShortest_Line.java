package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Вводятся 5 строк. Программа считает в порядке ввода какая фраза самая длинная или самая короткая.
 * Выводит на экран ту фразу, что Самая_короткая ИЛИ Самая_длинная попадается первой, сверху вниз. Пример
 * Рука
 * Ян
 * Работник
 * Бил
 * Дин
 *  По такому принципу программа выведит "Ян", т.к. самая короткая строка попалась первой
 * */

public class ArrayList_LongestOrShortest_Line {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <String> strings = new ArrayList();
        int maxLine = Integer.MIN_VALUE;
        int minLine = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++){
            strings.add(rd.readLine());
            if (maxLine <= strings.get(i).length()) maxLine = strings.get(i).length();
            if (minLine >= strings.get(i).length()) minLine = strings.get(i).length();
        }

        for (int i=0; i < strings.size(); i++) {
            if (maxLine == strings.get(i).length()) {
                System.out.println(strings.get(i));
                break;
            } else if (minLine == strings.get(i).length()){
                System.out.println(strings.get(i));
                break;
            }
        }
    }
}
