package edu.project4.Transformations;

import edu.project4.Models.AffineCoefficients;
import edu.project4.Models.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public class AffineTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return null;
    }

    @NotNull
    @Override
    public <V> Function<V, Point> compose(@NotNull Function<? super V, ? extends Point> before) {
        return Transformation.super.compose(before);
    }

    @NotNull
    @Override
    public <V> Function<Point, V> andThen(@NotNull Function<? super Point, ? extends V> after) {
        return Transformation.super.andThen(after);
    }

    public static List<AffineCoefficients> getCoeff() {
        List<AffineCoefficients> affineCoefficientsList = new ArrayList<>();
        int n = 0;
        Random random = new Random();
        double a, b, c, d, e, f;
        int rr, gg, bb;
        while (n <= 4) {
            a = random.nextDouble(-1.5, 1.5);
            b = random.nextDouble(-1.5, 1.5);
            c = random.nextDouble(-1.5, 1.5);
            d = random.nextDouble(-1.5, 1.5);
            e = random.nextDouble(-1.5, 1.5);
            f = random.nextDouble(-1.5, 1.5);

            rr = random.nextInt(255);
            gg = random.nextInt(255);
            bb = random.nextInt(255);
            if (!checkCoeff(a, b, c, d, e, f)) {
                continue;
            }
            affineCoefficientsList.add(new AffineCoefficients(a, b, c, d, e, f, rr, gg, bb));
        }
        return null;
    }

    private static boolean checkCoeff(double a, double b, double c, double d, double e, double f) {
        if ((a * a + b * b) < 1 && (b * b + e * e) < 1 &&
            (a * a + b * b + b * b + e * e) < 1 + Math.pow(a * e - b * d, 2)) {
            return true;
        }
        return false;
    }
}
