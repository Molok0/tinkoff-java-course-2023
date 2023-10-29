package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    public static String getName() {
        return name;
    }

    public static int getCost() {
        return cost;
    }

    private static String name;
    private static int cost;

    @Override
    public int compareTo(@NotNull Stock o) {
        return this.getCost() - o.getCost();
    }
}
