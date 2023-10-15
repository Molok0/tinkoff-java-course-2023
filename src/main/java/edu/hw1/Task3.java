package edu.hw1;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        sort(a1);
        sort(a2);
        if (a1[0] > a2[0] && a1[a1.length - 1] < a2[a2.length - 1]) {
            return true;
        } else {
            return false;
        }
    }
}
