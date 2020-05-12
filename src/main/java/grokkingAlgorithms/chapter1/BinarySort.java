package grokkingAlgorithms.chapter1;

import utils.ForArrayList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * В разработке
 */

public class BinarySort {

    public static void main(String[] args) {
        System.out.println("Заполняем лист");
        long l = System.currentTimeMillis();
        ArrayList<String> list = ForArrayList.getRandomStrings(10_000_000, 12, true);
        Collections.sort(list);
        System.out.println("Заполнение листа заняло = " + (System.currentTimeMillis() - l) + "мс");

        System.out.print("Проверяем на уникальность значений - ");
        if (hasDuplicates(list)) return;

        System.out.println("\nВыбираем значение: ");
        int index = (int) (Math.random() * 2_000_000_000) % list.size();
        String line = list.get(index);
        System.out.println(index + " = " + line);
        System.out.println("Ищем...\n");

        long start = System.currentTimeMillis();
        int result = binarySearch(list, line);
        long end = System.currentTimeMillis();

        System.out.println(result == -1 ? "Поиск не нашел элемент" : "Значение \"" + line + "\" под номером " + result);
        System.out.println("Заняло = " + (end - start) + "мс");

        System.out.println("\nОбычный поиск перебором занимает...");
        start = System.currentTimeMillis();
        int result2 = usualSearch(list, line);
        end = System.currentTimeMillis();
        System.out.println(end - start + "мс, index = " + result2);

        System.out.println("\n=======================================");
        System.out.println("При переборе 6кк строк - 0мс vs 200мс");
    }

    private static int usualSearch(ArrayList<String> list, String line) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(line)) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(ArrayList<String> list, String line) {
        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int diff = list.get(mid).compareTo(line);    // так все просто.. я уж подумал все, габелла

            if (diff == 0) {
                return mid;
            } else if (diff > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * проверяет, есть ли повторы.. при бинарном поиске, если есть повторы - то выдать может другой ответ.. просто из
     * за того, что он нашел такой элемент, но не на том месте, на котором я его выбрал. И тогда ответ будет не совсем
     * корректным, точнее я не смогу проверить его правильность
     *
     * @param list
     * @return
     */
    public static boolean hasDuplicates(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && (list.get(i).equals(list.get(i + 1)))) {
                System.out.println("наден повтор, нужно перезапустить программу");
                return true;
            }
//            System.out.println((i+1) + ". " + list.get(i));
        }
        System.out.println("повторов нет");
        return false;
    }
}
