package edu.hw3;

public class Task4 {
    private static String[] roman = new String[] {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static int[] arabic = new int[] {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public static String convertToRoman(int arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();
        Integer originalNumber = arabicNumber;
        for (int i = 0; i < roman.length; i++) {
            while (originalNumber >= arabic[i]) {
                romanNumeral.append(roman[i]);
                originalNumber -= arabic[i];
            }
        }
        return romanNumeral.toString();
    }
}
