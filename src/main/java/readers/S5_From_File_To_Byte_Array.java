package readers;

import java.io.*;
import java.util.Arrays;

public class S5_From_File_To_Byte_Array {

    private static byte[] array;

    public static void main(String[] args) {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/MyFileTest.txt";

        // Обычный способ. Считали файл, "создали" массив размером бит файла
        try (InputStream os = new FileInputStream(path)) {
            array = new byte[os.available()];
            while (os.available() > 0) {                // скопировали в массив
                os.read(array, 0, array.length);    //  можно писать просто (array) или  (массив, от индекса, до)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (byte ar : array) {                         // вывели
            System.out.print((char) ar);
        }
    }
}
