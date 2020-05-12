package utils;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class ForArrayList {
    private static SplittableRandom RANDOM = new SplittableRandom();

    private static char[] SMALL = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static char[] ALL ={'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

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

    public static final ArrayList<String> getRandomStrings(int elements, int minLength, int maxLength) {
        return getRandomStrings(elements, minLength, maxLength, false);
    }

    public static final ArrayList<String> getRandomStrings(int elements, int length, boolean onlySmall) {
        return getRandomStrings(elements, length, length+1, onlySmall);
    }

    public static final ArrayList<String> getRandomStrings(int elements, int length) {
        return getRandomStrings(elements, length, false);
    }
}
