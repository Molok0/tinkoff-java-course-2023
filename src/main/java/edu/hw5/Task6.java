package edu.hw5;

import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean stringIsSubsequenceOfString(String specifiedString, String anotherString) {
        return Pattern.compile(specifiedString).matcher(anotherString).find();
    }
}
