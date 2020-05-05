package archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Программа принимает строку и изменяет её таким образом, что каждое слово начинается с большей буквы.
 * Пример:
 * "машина по воздуху летала" -> "Машина По Воздуху Летала"
 */

public class String_Change_First_Letter_To_Upper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
//      text = noSpace(text);  - метод, что я создал не нужен. Но сам метод все равно интересен
        text = text.trim();

        char[] chars = text.toCharArray();                          // создаем массив символов
        chars[0] = Character.toUpperCase(chars[0]);                 // меняем первый символ на большую

        for (int i = 0; i < text.length(); i++) {                   // проходимся по всем символам
            if (chars[i] == ' ') {                                  // если сейчас символ это пробел
                chars[i+1] = Character.toUpperCase(chars[i+1]);     // поменять след. символ на большую букву
            }
        }
        System.out.println(chars);                                  // вывести массив символов

//      или можно перевести обратно в строку:
//      String finishedText = new String(chars);
//      System.out.println(finishedText);

    }

    /** Метод по удаленю пробела в конце. СЧИТАЕТСЯ НЕНУЖНЫМ, из за .trim() что делает тоже самое */
    private static String noSpace(String text) {
        StringBuffer noSpace = new StringBuffer(text);              // у StringBuffer можно удалять символы в строке
        if (noSpace.charAt(noSpace.length()-1) == ' ') {            // если последний символ = строка
            noSpace.delete(noSpace.length()-1, noSpace.length());   // удалить её .delete(от, до);
        }
        return new String(noSpace);
    }

}
