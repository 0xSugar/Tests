package archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_DeletingDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 14, 52, 32, 32, 14);
                                            // 14 52 32
        ArrayList<Integer> copy = new ArrayList<>(list);

        for (Integer k : list) {
            int count = 0;
            for (int i = 0; i < copy.size(); i++) {
                if (k.equals(copy.get(i))) {
                    count++;
                }
                if (count >= 2) {
                    copy.remove(i);
                    i--;
                }
            }
        }

        System.out.println(copy);
    }
}
