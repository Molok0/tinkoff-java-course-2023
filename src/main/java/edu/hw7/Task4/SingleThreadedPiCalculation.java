package edu.hw7.Task4;

import java.security.SecureRandom;

public final class SingleThreadedPiCalculation {

    private static long totalCount = 0;
    private static long circleCount = 0;
    private static final int R = 1;
    private static final int D = 2;
    private static final int FOUR = 4;

    private SingleThreadedPiCalculation() {
    }

    public static double getPi(int n) {
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < n; i++) {
            double x = secureRandom.nextDouble(D) - 1;
            double y = secureRandom.nextDouble(D) - 1;
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(R, 2)) {
                circleCount += 1;
            }
            totalCount += 1;
        }
        return FOUR * ((double) circleCount / (double) totalCount);
    }
}
