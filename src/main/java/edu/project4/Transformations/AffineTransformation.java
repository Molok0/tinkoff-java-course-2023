package edu.project4.Transformations;

import edu.project4.Models.AffineCoefficients;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AffineTransformation {
    private static final double RANGE_MIN = -1.5;
    private static final double RANGE_MAX = 1.5;
    private static final int MAX_COLOR = 256;
    private static final int MAX_LIST_LEN = 4;

    private AffineTransformation() {
    }

    public static List<AffineCoefficients> getCoeff() {
        List<AffineCoefficients> affineCoefficientsList = new ArrayList<>();
        int n = 0;
        Random random = new Random();

        double a;
        double b;
        double c;
        double d;
        double e;
        double f;
        int rr;
        int gg;
        int bb;
        while (n <= MAX_LIST_LEN) {
            a = random.nextDouble(RANGE_MIN, RANGE_MAX);
            b = random.nextDouble(RANGE_MIN, RANGE_MAX);
            c = random.nextDouble(RANGE_MIN, RANGE_MAX);
            d = random.nextDouble(RANGE_MIN, RANGE_MAX);
            e = random.nextDouble(RANGE_MIN, RANGE_MAX);
            f = random.nextDouble(RANGE_MIN, RANGE_MAX);

            rr = random.nextInt(MAX_COLOR);
            gg = random.nextInt(MAX_COLOR);
            bb = random.nextInt(MAX_COLOR);
            if (!checkCoeff(a, b, c, d, e, f)) {
                continue;
            }
            affineCoefficientsList.add(new AffineCoefficients(a, b, c, d, e, f, rr, gg, bb));
            n += 1;
        }
        return affineCoefficientsList;
    }

    private static boolean checkCoeff(double a, double b, double c, double d, double e, double f) {
        if ((a * a + b * b) < 1 && (b * b + e * e) < 1 && (a * a + b * b + b * b + e * e) < 1
            + Math.pow(a * e - b * d, 2)) {
            return true;
        }
        return false;
    }
}
