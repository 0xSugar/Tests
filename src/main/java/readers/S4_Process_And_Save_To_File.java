package readers;

import java.io.*;
import java.util.ArrayList;

public class S4_Process_And_Save_To_File {

    private static ArrayList<String> stringList = new ArrayList<>();
    private static ArrayList<Integer> intList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Начнем с чисел. Наша цель - выгрузить в лист, обработать и сохранить в файл
        String firstFile = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/File_of_numbs.txt";
        String doneSort = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/Sorted_numbs.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(firstFile)));  // читаем
        BufferedWriter bw = new BufferedWriter(new FileWriter(doneSort));                               // выгружаем
        while (br.ready()) {
            int numb = Integer.parseInt(br.readLine());     // взяли строку, привели к int
            if (numb > 50 && numb < 100) {                  // если число больше 50 и меньше 100
                intList.add(numb);                          // добавили в лист
            }
        }

        while (intList.size() != 0) {
            int numb = intList.get(0);                      // взяли первое значение в листе
            bw.write(numb + "\n");                     // записали
            intList.remove(0);                       // удалили
        }
        br.close();
        bw.close();

        // Удаляем строки
        firstFile = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/File_of_names.txt";
        doneSort = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/Sorted_names.txt";

        br = new BufferedReader(new InputStreamReader(new FileInputStream(firstFile))); // читаем
        bw = new BufferedWriter(new FileWriter(doneSort, false));               // выгружаем
        while (br.ready()) {
            String line = br.readLine();
            if (line.equals("Marta") || line.equals("Alex")) {
                stringList.add(line);
            }
        }
        while(stringList.size() != 0) {
            String line = stringList.get(0);
            bw.write(line + "\n");
            stringList.remove(0);
        }
        br.close();
        bw.close();

    }
}



