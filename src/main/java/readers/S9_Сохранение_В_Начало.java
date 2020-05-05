package readers;

import java.io.*;

/**
 * Если 2 файла. Оно берет данные из второго и сохраняет в начало в первый файл
 * P.S.: false - стирает файл только 1 раз, последующие запили файл не перезаписывают
 */

public class S9_Сохранение_В_Начало {
    public static void main(String[] args) throws IOException {
        // считываем путь к файлам
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        // заносим данные первого файла в "буфер"
        FileInputStream fis = new FileInputStream(file1);
        byte[] buf = new byte[fis.available()];
        if (fis.available() > 0) {
            fis.read(buf);
        }
        fis.close();

        // переписывает второй файл в первый
        fis = new FileInputStream(file2);
        FileOutputStream fos = new FileOutputStream(file1, false);
        while (fis.available() > 0) {
            fos.write(fis.read());
        }
        fis.close();
        fos.close();

        // добавляем буфер к первому файлу
        fos = new FileOutputStream(file1, true);
        fos.write(buf);
        fos.close();
    }
}

/*          #2
// считываем путь к файлам
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        // заносим данные первого файла в "буфер"
        FileInputStream fis = new FileInputStream(file1);
        byte[] buf = new byte[fis.available()];
        if (fis.available() > 0) {
            fis.read(buf);
        }
        fis.close();

        // заносим данные второго файла в "буфер"
        fis = new FileInputStream(file2);
        byte[] buf2 = new byte[fis.available()];
        while (fis.available() > 0) {
            fis.read(buf2);
        }
        fis.close();

        // записываем в файл
        FileOutputStream fos = new FileOutputStream(file1, false);
        fos.write(buf2);
        fos.write(buf);
        fos.close();
 */ // #2

