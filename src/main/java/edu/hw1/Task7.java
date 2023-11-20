package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    private final static int NUMBER_SYSTEM = 2;

    public static int rotateLeft(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int newShift = shift;
        if (binN.length() < shift) {
            newShift = shift % binN.length();
        }
        return Integer.parseInt(binN.substring(newShift) + binN.substring(0, newShift), NUMBER_SYSTEM);
    }

    public static int rotateRight(int n, int shift) {
        String binN = Integer.toBinaryString(n);
        int newShift = shift;
        if (binN.length() < shift) {
            newShift = shift % binN.length();
        }

        //return rotateLeft(n, binN.length() - new_shift);
        return Integer.parseInt(
            binN.substring(binN.length() - newShift) + binN.substring(0, binN.length() - newShift), NUMBER_SYSTEM);
    }
}
