package bookGrokkingAlgorithms.chapter1;

import Utils.ForArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SplittableRandom;

public class BinarySort {

    public static void main(String[] args) {
        ArrayList<String> list = ForArrayList.createRandomArrayList(100, 2, 12, true);
        Collections.sort(list);


        System.out.println(list);
    }
}
