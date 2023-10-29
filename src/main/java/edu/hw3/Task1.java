package edu.hw3;

public class Task1 {
    private static int maxLowercaseLetter = (int) 'z';
    private static int minLowercaseLetter = (int) 'a';
    private static int maxCapitalLetter = (int) 'Z';
    private static int minCapitalLetter = (int) 'A';

    public static String atbash(String toDecodeString) {
        char[] x = new char[toDecodeString.length()];
        for (int i = 0; i < toDecodeString.length(); i++) {
            char letter = toDecodeString.charAt(i);
            int a;
            int codeLetter = letter;
            if (96 < codeLetter && codeLetter < 123) {
                a = (codeLetter < 110) ? 110 % codeLetter + 109 :
                    minLowercaseLetter - codeLetter + maxLowercaseLetter;
                x[i] = (char) a;
            } else if (64 < codeLetter && codeLetter < 91) {
                a = (codeLetter < 78) ? 78 % codeLetter + 77 :
                    minCapitalLetter - codeLetter + maxCapitalLetter;
                x[i] = (char) a;
            } else {
                x[i] = letter;
            }
        }
        return new String(x);
    }
}
