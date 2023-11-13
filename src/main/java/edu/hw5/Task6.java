package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    public static boolean stringIsSubsequenceOfString(String specifiedString, String anotherString) {
        return Pattern.compile(specifiedString).matcher(anotherString).find();
    }
}
