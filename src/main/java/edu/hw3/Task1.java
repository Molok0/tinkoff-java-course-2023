package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static String atbash(String toDecodeString) {
        char[] x = new char[toDecodeString.length()];
        for (int i = 0; i < toDecodeString.length(); i++){
            char letter = toDecodeString.charAt(i);
            int a;
            if (Character.isLetter(letter)) {
                a = ((int) letter < 110) ? (int) letter + 13 : (int) letter - 13;
                x[i] = (char) a;
            }
            else x[i] = letter;
        }
        return new String(x);
    }

    public static void main(String[] args) {
        System.out.println(atbash("Hello world!"));
    }
}
