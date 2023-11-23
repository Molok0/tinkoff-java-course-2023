package edu.hw7.Task4;

import java.io.PrintStream;

public final class PiCalculation {
    private PiCalculation() {
    }

    private static final int ITERATION1000 = 1000;
    private static final int ITERATION10000 = 10000;
    private static final int ITERATION100000 = 100000;
    private static final int CALCULATION_NUMBER = 3;
    private static final String BUST_STRING = "Многопоточный код ускоряет вычесление в: ";

    public static void printStat() {

        PrintStream printStream = new PrintStream(System.out);

        long startTime = System.currentTimeMillis();

        printStream.println(SingleThreadedPiCalculation.getPi(ITERATION1000));
        long endTime = System.currentTimeMillis();

        long duration1 = endTime - startTime;

        startTime = System.currentTimeMillis();
        printStream.println(MultiThreadedPiCalculation.getPi(ITERATION1000));
        endTime = System.currentTimeMillis();
        double duration2 = endTime - startTime;

        var a1 = duration1 / duration2;
        printStream.println(BUST_STRING + duration1 / duration2 + "раз\n");

        startTime = System.currentTimeMillis();

        printStream.println(SingleThreadedPiCalculation.getPi(ITERATION10000));
        endTime = System.currentTimeMillis();

        duration1 = endTime - startTime;

        startTime = System.currentTimeMillis();
        printStream.println(MultiThreadedPiCalculation.getPi(ITERATION10000));
        endTime = System.currentTimeMillis();
        duration2 = endTime - startTime;

        var a2 = duration1 / duration2;
        printStream.println(BUST_STRING + duration1 / duration2 + " раз\n");

        printStream.println(SingleThreadedPiCalculation.getPi(ITERATION100000));
        endTime = System.currentTimeMillis();

        duration1 = endTime - startTime;

        startTime = System.currentTimeMillis();
        printStream.println(MultiThreadedPiCalculation.getPi(ITERATION100000));
        endTime = System.currentTimeMillis();
        duration2 = endTime - startTime;

        var a3 = duration1 / duration2;
        printStream.println(BUST_STRING + duration1 / duration2 + " раз");

        printStream.println("Среднее время ускорения решения: " + (a1 + a2 + a3) / CALCULATION_NUMBER);

    }

}
