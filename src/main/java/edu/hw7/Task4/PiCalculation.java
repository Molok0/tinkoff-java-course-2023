package edu.hw7.Task4;

import java.io.PrintStream;

public final class PiCalculation {
    private PiCalculation() {
    }

    private static final int ITERATION10000 = 10000;

    public static void printStat() {

        PrintStream printStream = new PrintStream(System.out);

        long startTime = System.currentTimeMillis();

        printStream.println(SingleThreadedPiCalculation.getPi(ITERATION10000));
        long endTime = System.currentTimeMillis();

        long duration1 = endTime - startTime;

        startTime = System.currentTimeMillis();
        printStream.println(MultiThreadedPiCalculation.getPi(ITERATION10000));
        endTime = System.currentTimeMillis();
        double duration2 = endTime - startTime;

        var a1 = duration1 / duration2;
        printStream.println("Многопоточный код ускоряет вычесление в: " + duration1 / duration2 + " раз");

    }
}
