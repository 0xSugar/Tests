package archive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Идея взята с JavaRush, реализация своя
 * Есть 2 файла. Предполагается, что это 2 версии. Измененная и старая.
 * 1й файл - старая версия
 * 2й файл - новая версия, измененная (*главная)
 *
 * Программа принимает 2 файла и на выходе показывает, какие строки изменились, какие были удалены или добавлены.
 */

public class JoiningChangedLinesInTheFile {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        // Создаем листы и записываем в них значения файлов
        ArrayList<String> list1 = importfiles(file1);
        ArrayList<String> list2 = importfiles(file2);

        // Основная логика, заполняем lines правильными значениями
        joinTheFiles(list1, list2);

        // Вывод
        for (LineItem item : lines) {
            System.out.println(item);
        }
    }

    public static ArrayList<String> importfiles(String file) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    public static void joinTheFiles(ArrayList<String> list1, ArrayList<String> list2) {
        // Пока длина не одинковая - будет добавлять пустые строки в лист с наименьшем кол-вом
        while (list1.size() != list2.size()) {
            if (list1.size() > list2.size()) {
                list2.add("");
            } else {
                list1.add("");
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            String line1 = list1.get(i);
            String line2 = list2.get(i);
            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
            } else {
                if (line1.isEmpty() || line1.isBlank()) {
                    lines.add(new LineItem(Type.ADDED, line2));
                } else if (line2.isEmpty() || line2.isBlank()) {
                    lines.add(new LineItem(Type.REMOVED, line1));
                } else {
                    System.out.println("Ни одна строка не является пустой");
                }
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString() {
            String part = null;
            if (type.equals(Type.ADDED)) part = "ADDED";
            if (type.equals(Type.REMOVED)) part = "REMOVED";
            if (type.equals(Type.SAME)) part = "SAME";
            return part + " " + line;
        }
    }
}
