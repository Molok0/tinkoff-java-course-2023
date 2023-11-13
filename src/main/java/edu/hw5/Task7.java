package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {

    public static boolean leastThreeCharactersAndThirdIsZero(String input) {
        return Pattern.compile("^[0|1]{2}0$").matcher(input).matches();
    }

    public static boolean symbolBeginningEqualsEnd(String input) {
        return Pattern.compile("^(0|1).*\\1$").matcher(input).matches();
    }

    /*
     * The method checks that the string length is not less than 1 and not more than 3
     */
    public static boolean lengthCheck(String input) {
        return Pattern.compile("^.{1,3}$").matcher(input).matches();
    }

}
