package edu.hw1;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return false;
        }
        int min_a1 = Arrays.stream(a1).min().getAsInt();
        int max_a1 = Arrays.stream(a1).max().getAsInt();
        int min_a2 = Arrays.stream(a2).min().getAsInt();
        int max_a2 = Arrays.stream(a2).max().getAsInt();
        return min_a1 > min_a2 && max_a1 < max_a2;
    }
}
