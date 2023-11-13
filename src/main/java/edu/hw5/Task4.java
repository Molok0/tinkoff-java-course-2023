package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static boolean checkPassword(String password) {
        var pattern = Pattern.compile(".*[~!@#$%^&*|].*");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
