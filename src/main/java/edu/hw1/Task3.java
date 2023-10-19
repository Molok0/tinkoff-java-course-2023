package edu.hw1;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return false;
        }
        int minA1 = Arrays.stream(a1).min().getAsInt();
        int maxA1 = Arrays.stream(a1).max().getAsInt();
        int minA2 = Arrays.stream(a2).min().getAsInt();
        int maxA2 = Arrays.stream(a2).max().getAsInt();
        return minA1 > minA2 && maxA1 < maxA2;
    }
}
