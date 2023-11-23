package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public final class MultiThreadedPiCalculation {
    private static long circleCount = 0;

    private static final double R = 1.0;
    private static final int FOUR = 4;

    private MultiThreadedPiCalculation() {
    }

    public static double getPi(int n) {
        circleCount = LongStream.rangeClosed(1, n).filter(z -> {
            double x = ThreadLocalRandom.current().nextDouble(R);
            double y = ThreadLocalRandom.current().nextDouble(R);
            return (Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(R, 2);
        }).count();
        return FOUR * ((double) circleCount / (double) n);
    }

}
