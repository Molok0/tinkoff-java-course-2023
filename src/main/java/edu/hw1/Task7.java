package edu.hw1;

public class Task7 {
    private static int numberSystem = 2;

    public static int rotateLeft(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int new_shift = shift;
        if (binN.length() < shift) {
            new_shift = binN.length() % shift;

        }
        return Integer.parseInt(binN.substring(new_shift) + binN.substring(0, new_shift), numberSystem);
    }

    public static int rotateRight(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int new_shift = shift;
        if (binN.length() < shift) {
            new_shift = binN.length() % shift;
        }
        System.out.println(new_shift);
        return Integer.parseInt(
            binN.substring(binN.length() - new_shift) + binN.substring(0, binN.length() - new_shift), numberSystem);
    }
}
