package archive;

import java.io.*;
import java.util.*;

public class Recursion_Country_Words {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/skul/IdeaProjects/Tests/src/main/java/archive/recursion_file.txt";
        BufferedReader rd = new BufferedReader(new FileReader(fileName));
        String[] arr = null;
        if (rd.ready()) arr = rd.readLine().split("\\s");
        rd.close();

        StringBuilder result = getLine(arr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;


        ArrayList<String> cities = new ArrayList<>();
        Collections.addAll(cities, words);

        for (int i = 0; i < cities.size(); i++) {

            ArrayList<String> copy = new ArrayList<>(cities);
            Collections.sort(copy);
            result.append(copy.get(i)).append(" ");
            copy.remove(i);

            if (checkEverything(result, copy, 0)) {
//                return result.delete(result.length() - 1, result.length());
                return result;
            }
            result.delete(0, result.length());
        }
        result.append(" ");
//        return result.length() < 1 ? result : result.delete(result.length() - 1, result.length());
        return result;
    }

    private static boolean checkEverything(StringBuilder result, ArrayList<String> copy, int index) {
        // проверка - если индекс = размеру листу - эта идея провальная, вернуть false
        if (copy.size() == index && index != 0) return false;
        // начало
        ArrayList<String> instant = new ArrayList<>(copy);  // копируем новый лист
        String word = instant.get(index).toLowerCase();     // берем слово
        char lastChar = result.toString().toLowerCase().charAt(result.length() - 2);// последний символ в строке result
        char firstChar = word.toLowerCase().charAt(0);                      // первый символ в слове
        if (lastChar == firstChar) {                                        // сравниваем
            int count = getRepeatNumber(instant, index);        // Если подошло - проверяем, слов с такой буквой одно или больше
            if (count == 1) {   // Если 1 слово
                result.append(instant.get(index)).append(" ");// добавляем
                instant.remove(index);          // удалям слово по индексу
                if (instant.size() != 0) {      // если лист после удаления НЕ пустой -> запутить еще раз передав лист
                    index = 0;                  // обнуляем индекс
                    return checkEverything(result, instant, index);
                }
                return true;                    // если лист после удаления пустой - вернуть true
            } else {            // Если несколько слов
                for (String line : instant) {           // проходимся по всем
                    if (line.toLowerCase().charAt(0) == firstChar) {  // если буквы одинаковые, то для каждого слова:
                        ArrayList<String> instant2 = new ArrayList<>(instant);  // создать свое arraylist
                        instant2.remove(line);                                  // из которого удаляем это слово
                        StringBuilder copyString = new StringBuilder(result);   // создать свой билдер
                        copyString.append(line).append(" ");                    // добавляем это слово в свою строку
                        index = 0;                                              // обнуляем индекс
                        if (checkEverything(copyString, instant2, index)) {     // проверяем эту комбинацию
                            result.delete(0, result.length());                  // если успешна - присвоить result
                            result.append(copyString);
                            return true;                                        // если успешна - вернуть успех
                        }
                    }
                }
                return false;
            }
        }
        return checkEverything(result, instant, index + 1); // ЕСЛИ буква НЕ совпадает - вызвать на следующее слово
    }

    private static int getRepeatNumber(ArrayList<String> copy, int startWith) {
        int count = 0;
        char firstChar = copy.get(startWith).charAt(0);
        for (String line : copy) {
            if (line.charAt(0) == firstChar) {
                count++;
            }
        }
        return count;
    }

}
