package readers;

import java.io.*;

public class S2_Get_And_Save {

    public static void main(String[] args) throws IOException {
        // суть данного - считывает число с файла и присваивает перемнной counter
        String counterPath = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/Counter.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(counterPath)));
        int counter = 1 + Integer.parseInt(br.readLine());  // увеличивает на 1 - записывает в файл + добавляет
        br.close();                                         // число к названию файла - secondFile
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(counterPath)));
        bw.write(String.valueOf(counter));          // BufferedWriter работает с символами, что бы записать
        bw.close();

        // Начало - считывание пути Первого_файла (откуда) и Второго (куда)
        String firstFile = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/MyFileTest.txt";
        String secondFile = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/zNewFile_" + counter;

        // Тут, по сколько не нужна обработка можно просто побайтово скопировать и вставить. Для этого
        InputStream is = new FileInputStream(firstFile);
        OutputStream os = new FileOutputStream(secondFile, true);

        while (is.available() > 0) {
            os.write(is.read());
        }
        is.close();
        os.close();
    }
}
