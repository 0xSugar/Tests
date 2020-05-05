package archive;

import java.util.Arrays;

/**
 * В main представлен оптимальный вариант, более правильный.
 *
 * Ниже мой код, что я написал лишь зная по какому принципу он должен работать, кривой
 * косой, но работает, сколько бы лишних элементов там ни было) *без Google
 */

public class BinarySort {
    public static void main(String[] args) {
        int[] arr = new int[20000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20000);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 1000, 0, arr.length));
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}


/*  Мой, родной)
    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = -5; i < arr.length + 10; i++) {
            System.out.println("number (" + i + ") = " +getIndexOf(arr, i) + " (" + trueOrFalse(arr, i) + ")");
        }
    }

    private static int getIndexOf(int[] arr, int number) {
        int result = -1;

        int start = 0;
        int end = arr.length;
        int temp = arr.length / 2;

        while (true) {
            if (start == end-1) {       // без этого не видит первый элемент
                if (number == end-1) {
                    result = end-1;
                    break;
                }
            }
            // если не ставить start = end-1, то при
            if (start == end || start == end-1) break;  // чистах больше, чем есть
            // в массиве - получается бесконечный цикл
            if (number == arr[temp]) {  // т.е. в массиве числа от 0 до 49, если
                result = temp;          // искать 100 - получится бесконечный цикл
                break;
            } else if (number < arr[temp]) {
                end = temp;
                temp = (end + start) / 2;
            } else if (number > arr[temp]) {
                start = temp;
                temp = (end + start) / 2;
            }
        }

        return result;
    }

    private static boolean trueOrFalse(int[] arr, int numb) {
        for (int i = 0; i < arr.length; i++) {
            if (numb == arr[i]) {
                return true;
            }
        }
        return false;
    }
*/