package readers;

import java.io.*;

public class S1_Read_From_File_Easy {
    public static void main(String[] args) throws IOException {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/MyFileTest.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        /* взять ссылку на объект
        InputStream is = new FileInputStream(path);

        Wrapper, перевод байтов в символы
        InputStreamReader isr = new InputStreamReader(is);

        присваиваем это буферизованному ридеру (он все это загоняет в буфер и от туда работает быстрее
        BufferedReader reader = new BufferedReader(isr); */

        // вывести
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
    }
}
