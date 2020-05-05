package readers;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Нужно понять такую основу.. Есть 4 класса - InputStream, OutputStream, Reader, Writer.
 * Первые 2 отвечают за байтовый поток, вторые - за символьные.
 *
 * Считывание с файла происходит побайтово (обычный FileInputStream). Т.е. считали 1 байт - записали. И это долго.
 * Можно же записывать по пару тысяч байтов за раз (это BufferedInputStream). Сначала байты помещаются в буфер и по
 * его достижению - записываются в файл. Дефолтный размер буфера = 8кб.. да да да, 8000 байт.
 *
 * Сейчам мы использует этот самый буфер для быстрого считывания данные, а так же посмотрим как это отразится на
 * скорости. Что будет:
 * Test_1 - Мы считаем файл побайтово и каждый занесем в массив
 * Test_2 - Мы считаем файл за раз (через буфер) и каждый байт занесем в массив
 * Test_3 - Считаем через буфер и переведем в символы, заносим в массив char
 * Test_4 - Считываем через буффер и переводим в буффер строк, заносим в лист строк
 */

public class S6_Buffered_Is_Better {

    private static byte[] first;        // это для побайтового
    private static byte[] second;       // это для буферного
    private static char[] third;        // это для символьного
    private static ArrayList<String> forth;

    public static void main(String[] args) throws IOException {
        String path = "/Users/skul/IdeaProjects/Tests/src/com/company/readers/MyFileText_BigOne.txt";
        System.out.println("Тест №1. Считаем файл побайтово");
        Date d1 = new Date();                       // создаем точку времени
        FileInputStream is = new FileInputStream(path); // Считываем файл
        first = new byte[is.available()];           // иниц. массив
        while (is.available() > 0) {
            is.read(first);                         // заносим все в массив
        }
        Date d2 = new Date();                       // ставим вторую точку времни
        is.close();
        System.out.println("Все прошло успешно, времени ушло на операцию = " + (d2.getTime() - d1.getTime()) + "мс. " + "Элементов в массиве: " + first.length);


        System.out.println("\n\nТест №2. Считаем файл буфером");
        d1 = new Date();
        BufferedInputStream is2 = new BufferedInputStream(new FileInputStream(path));
        second = new byte[is2.available()];
        while (is2.available() > 0) {
            is2.read(second);
        }
        d2 = new Date();
        is2.close();
        System.out.println("Все прошло успешно, времени ушло на операцию = " + (d2.getTime() - d1.getTime()) + "мс. " + "Элементов в массиве: " + second.length);


        System.out.println("\n\nТест№3. Считываем через буфер, переводим в символы и заносим в массив char");
        d1 = new Date();
        FileInputStream fis = new FileInputStream(path);        // Создано, что бы получить длину для массива.
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(fis));
        third = new char[fis.available()];
        while (isr.ready()) {
            isr.read(third);
        }
        d2 = new Date();
        fis.close();
        isr.close();
        System.out.println("Все прошло успешно, времени ушло на операцию = " + (d2.getTime() - d1.getTime()) + "мс. " + "Элементов в массиве: " + third.length);


        System.out.println("\n\nТест№4. Считываем через буфер и переводим в буффер строк, заносим в ArrayList<String>");
        d1 = new Date();
        //                      Буфер строк    <-     Символы        <-      БуферБайтов     <-      Байты     <-Файл
        BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(path))));
        forth = new ArrayList<>();
        while (br.ready()) {
            forth.add(br.readLine());
        }
        br.close();
        d2 = new Date();
        System.out.println("Все прошло успешно, времени ушло на операцию = " + (d2.getTime() - d1.getTime()) + "мс. " + "Элементов в ArrayList: " + forth.size());
    }
}
