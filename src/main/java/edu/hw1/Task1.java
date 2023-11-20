package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private final static int SEC = 60;

    public static long minutesToSeconds(String a) {
        String[] time = a.split(":");

        int minuts = Integer.parseInt(time[0]);
        int secunds = Integer.parseInt(time[1]);

        if (secunds >= SEC) {
            return -1;
        }

        return minuts * SEC + secunds;
    }
}
