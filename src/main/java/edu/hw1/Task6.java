package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.min;
import static java.util.Collections.reverse;
import static java.util.Collections.sort;

public class Task6 {
    private static final int numberK = 6174;

    public static int countK(int number) {
        int count = 0;
        return start(number,count);
    }

    private static int start(int number, int count){
        if (number == numberK) {
            return count;
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();

            while (number != 0) {
                numbers.add(0, number % 10);
                number /= 10;
            }
            Collections.sort(numbers);
            int minNumber = digitsToNumber(numbers);
            Collections.reverse(numbers);
            int maxNumber = digitsToNumber(numbers);

            number = maxNumber - minNumber;
            count += 1;
            return start(number, count);
        }
    }

    private static int digitsToNumber(ArrayList<Integer> digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }

}

