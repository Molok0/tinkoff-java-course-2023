package edu.hw1;

import java.util.List;

public class Task1 {

    public static long minutesToSeconds(String a) {
        String[] time = a.split(":");

        int minuts = Integer.parseInt(time[0]);
        int secunds = Integer.parseInt(time[1]);

        if (secunds >= 60) {
            return -1;
        }

        return minuts * 60 + secunds;
    }
}
