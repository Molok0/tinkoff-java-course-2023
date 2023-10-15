package edu.hw1;

import static java.lang.Math.abs;

public class Task2 {

    public static int countDigits(long number){
        int count;

        if (number == 0){
            count = 1;
        }else{
            count = (int) Math.log10(abs(number)) + 1;
        }
        return count;
    }
}
