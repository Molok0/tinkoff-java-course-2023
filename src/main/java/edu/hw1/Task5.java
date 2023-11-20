package edu.hw1;

public final class Task5 {

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {

        String currNumber = String.valueOf(number);
        if (currNumber.length() < 2) {
            return false;
        }
        if (isPalindrome(currNumber)) {
            return true;
        }

        StringBuilder result = new StringBuilder();
        if (currNumber.length() % 2 != 0) {
            currNumber = currNumber.concat("0");
        }
        for (int i = 0; i < currNumber.length() - 1; i += 2) {
            int sum =
                Character.getNumericValue(currNumber.charAt(i)) + Character.getNumericValue(currNumber.charAt(i + 1));
            result.append(sum);
        }
        return isPalindromeDescendant(Integer.parseInt(result.toString()));
    }

    private static boolean isPalindrome(String number) {
        int numberLength = number.length();
        for (int i = 0; i < numberLength; i++) {
            if (number.charAt(i) != number.charAt(numberLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
