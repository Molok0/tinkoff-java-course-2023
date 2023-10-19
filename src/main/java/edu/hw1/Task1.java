package edu.hw1;

public class Task1 {
    private static int sec = 60;

    public static long minutesToSeconds(String a) {
        String[] time = a.split(":");

        int minuts = Integer.parseInt(time[0]);
        int secunds = Integer.parseInt(time[1]);

        if (secunds >= sec) {
            return -1;
        }

        return minuts * sec + secunds;
    }
}
