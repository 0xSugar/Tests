package archive;

import java.util.ArrayList;

public class ArrayList_IfLetter {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("р");
        strings.add("лоза");
        strings.add("лллира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
/**                                                                                                 Проверка на то, как работает код indexOf ( 0 / -1) */
//                                                                                                  System.out.print("В слове \"" + strings.get(i) + "\" букв \'Р\' - " + strings.get(i).indexOf("р"));
//                                                                                                  System.out.println(". а букв \'Л\' - " + strings.get(i).indexOf("л"));
/**                                                                                                 Проверка на то, как работает код contains (true / false) */
//                                                                                                  System.out.print("В слове \"" + strings.get(i) + "\" букв \'Р\' - " + strings.get(i).contains("р"));
//                                                                                                  System.out.println(". а букв \'Л\' - " + strings.get(i).contains("л"));
            if (strings.get(i).contains("р") == true && strings.get(i).contains("л")  == false) {
                strings.remove(i);
                i--;
            } else if (strings.get(i).contains("л") == true && strings.get(i).contains("р") == false) {
                strings.add(i, strings.get(i));
                i++;
            }

        }
        return strings;
    }
}
/** Старый код метода fix */ /*
    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {  // каждую строку перебирает по очереди
            String n = strings.get(i);
            int letL = 0, letR = 0;                     // сюда запишем кол-во букв Л и Р

            for (int j= 0; j < n.length(); j++){    // цикл для одного слова
                if (n.charAt(j) == 'л') letL++;
                if (n.charAt(j) == 'р') letR++;
            }

            if (letR > 0 && letL == 0) {
                strings.remove(i);
                i--;
            }
            if (letL > 0 && letR == 0) {
                strings.add(i, n);
                i++;
            }
        }
        return strings;
    }
*/
