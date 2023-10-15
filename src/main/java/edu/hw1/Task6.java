package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.reverse;
import static java.util.Collections.sort;

public class Task6 {
    private static int numberK = 6174;
    private static int count = 0;

    public static int countK(int number) {
        if (check(number)){
            return -1;
        }
        if (number == numberK) {
            return count;
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();

            while (number != 0) {
                numbers.add(0, number % 10);
                number /= 10;
            }
            Collections.sort(numbers);
            ArrayList<Integer> descendingOrder = new ArrayList<>(numbers);
            Collections.reverse(descendingOrder);

            number = digitsToNumber(descendingOrder) - digitsToNumber(numbers);
            count += 1;
            return countK(number);
        }
    }

    private static int digitsToNumber(ArrayList<Integer> digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }

    private static boolean check(int number){
        char[] num = Integer.toString(number).toCharArray();
        for (int i = 0; i < num.length - 1; i++){
            if (num[i] != num[i+1])
                return false;
        }
        return true;
    }
}

