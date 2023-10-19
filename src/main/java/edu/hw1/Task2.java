package edu.hw1;

public class Task2 {

    public static int countDigits(int number) {
        int count = 0;
        if (number == 0) {
            count = 1;
        } else {
            count = (int) Math.floor (Math.log10(Math.abs(number))) + 1;
        }
        return count;
    }
}
