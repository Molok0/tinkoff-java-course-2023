package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;

public final class Task6 {
    private static final int NUMBER_K = 6174;
    private static final int NUMBER_DIVIDE_10 = 10;
    private static final int INCREASE_ORDER = 10;

    private Task6() {
    }

    public static int countK(int number) {
        int count = 0;
        return start(number, count);
    }

    private static int start(int number, int count) {
        int tmp = number;
        if (check(tmp)) {
            return -1;
        }
        if (tmp == NUMBER_K) {
            return count;
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();

            while (tmp != 0) {
                numbers.add(0, tmp % NUMBER_DIVIDE_10);
                tmp /= NUMBER_DIVIDE_10;
            }
            Collections.sort(numbers);
            int minNumber = digitsToNumber(numbers);
            Collections.reverse(numbers);
            int maxNumber = digitsToNumber(numbers);

            tmp = maxNumber - minNumber;
            return start(tmp, count + 1);
        }
    }

    private static int digitsToNumber(ArrayList<Integer> digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * INCREASE_ORDER + digit;
        }
        return number;
    }

    private static boolean check(int number) {
        char[] num = Integer.toString(number).toCharArray();
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] != num[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
