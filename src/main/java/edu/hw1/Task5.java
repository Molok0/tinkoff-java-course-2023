package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task5 {
    private static int firstNumber;
    private static int secondNumber;
    public static boolean isPalindromeDescendant(int number){

        int firstNumber;
        int secondNumber;

        String currNumber = String.valueOf(number);
        System.out.println(currNumber);
        if (currNumber.length() < 2){
            return false;
        }
        if (isPalindrome(currNumber)){
            return true;
        }
        int descendant = 0;

        while (number > 0){
            firstNumber = number%10;
            secondNumber = number%100/10;
            number = number / 100;
            descendant = descendant * 10 + (firstNumber + secondNumber);
        }
        return isPalindromeDescendant(descendant);

    }

    private static boolean isPalindrome(String number){

        return number.equals(new StringBuilder(number).reverse().toString());
    }

}
