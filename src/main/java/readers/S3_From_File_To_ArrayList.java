package readers;

import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.util.ArrayList;

public class S3_From_File_To_ArrayList {

    // У нас есть 3 листа - Byte, Char и String
    private static ArrayList<Byte> byteList = new ArrayList<>();
    private static ArrayList<Character> charList = new ArrayList<>();
    private static ArrayList<String> stringList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/MyFileTest.txt";
        InputStream is = new FileInputStream(path);     // Взяли файл, сейчас он находится в виде битов
        System.out.println("\n ! Сейчас будет выведен Лист \"байт\" -> FileInputStream ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        while(is.available() > 0) {
            byteList.add((byte) is.read());
        }
        is.close();
        System.out.println("Размер листа байтов = " + byteList.size());
        byteList.forEach(x -> System.out.print(x + " "));

        System.out.println("\n\n ! Сейчас будет выведен Лист \"символов\" -> FileInputStream -> InputStreamReader ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- --");
        InputStream is2 = new FileInputStream(path);            // Считываем файл в битах
        InputStreamReader reader = new InputStreamReader(is2);  // Переводим в символы
        while(reader.ready()) {                         // BufferedReader - делает программу производительней
            charList.add((char)reader.read());          // но пока что я его не буду исползьвать
        }
        is2.close();
        reader.close();
        System.out.println("Размер листа символов = " + charList.size());
        charList.forEach(System.out::print);

        System.out.println("\n\n ! Сейчас будет выведен Лист \"строк\" -> FileInputStream -> InputStreamReader -> BufferedReader ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- --");
        BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        while (rd.ready()) {
            stringList.add(rd.readLine());
        }
        rd.close();
        System.out.println("Размер листа строк = " + stringList.size());
        stringList.forEach(System.out::println);
    }
}
