package utils;

import java.util.ArrayList;
import java.util.SplittableRandom;

/**
 * Личный вспомогательный клас для работы с коллекциями.
 */

public class ForArrayList {
    private static SplittableRandom RANDOM = new SplittableRandom();

    private static char[] SMALL = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static char[] ALL ={'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    /**
     * Создает ArrayList и заполняет разными элементами.
     * @param elements колличество "слов"
     * @param minLength мин длина слова
     * @param maxLength макс длина слова
     * @param onlySmall только маленькие буквы?
     * @return ArrayList с случайно сгенерированными словами
     */
    public static final ArrayList<String> getRandomStrings(int elements, int minLength, int maxLength, boolean onlySmall) {
        ArrayList<String> list = new ArrayList<>();
        char[] arr = onlySmall ? SMALL : ALL;

        for (int i = 0; i < elements; i++) {
            int letters = RANDOM.nextInt(minLength, maxLength);
            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < letters; j++) {
                int numb = RANDOM.nextInt(0, arr.length);
                builder.append(arr[numb]);
            }

            list.add(builder.toString());
        }
        return list;
    }

    // колличество слов | мин длина слова | макс длина слова
    public static final ArrayList<String> getRandomStrings(int elements, int minLength, int maxLength) {
        return getRandomStrings(elements, minLength, maxLength, false);
    }

    // колличество слов | точная длина | only Lowercase or Lowercase + Uppercase
    public static final ArrayList<String> getRandomStrings(int elements, int length, boolean onlySmall) {
        return getRandomStrings(elements, length, length+1, onlySmall);
    }

    // колличество слов | точная длина      (все буксы
    public static final ArrayList<String> getRandomStrings(int elements, int length) {
        return getRandomStrings(elements, length, false);
    }

    // по умолчанию - вернет лист с 10 слов маленьких или больших букв, длинной ровно 5
    public static final ArrayList<String> getRandomStrings() {
        return getRandomStrings(10, 5);
    }
}
