package grokkingAlgorithms.chapter1;

import utils.ForArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySortRecursion {
    public static void main(String[] args) {
        ArrayList<String> list = ForArrayList.getRandomStrings(10_000_000, 12, true);
        Collections.sort(list);

        if (BinarySort.hasDuplicates(list)) return;

        int index = (int) (Math.random() * 1_000_000_000) % list.size();
        System.out.println(index + " = " + list.get(index));

        long start = System.currentTimeMillis();
        int result = recursionBinarySearch(list, list.get(index), 0, list.size() - 1);
        long end = System.currentTimeMillis();

        System.out.println(result == -1 ? "Поиск не нашел элемент" : "Значение \"" + list.get(index) + "\" под номером " + result);
        System.out.println("Заняло = " + (end - start) + "мс");
    }

    public static int recursionBinarySearch(ArrayList<String> list, String key, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int diff = list.get(mid).compareTo(key);

        if (diff == 0) {
            return mid;
        } else if (diff > 0) {
            return recursionBinarySearch(list, key, low, mid - 1);
        } else {
            return recursionBinarySearch(list, key, mid + 1, high);
        }
    }
}
