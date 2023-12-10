package edu.project4.Transformations;

import edu.project4.Models.Point;

public class Swirl implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.pow(x * x + y * y, 0.5);
        double tmp1 = x * Math.sin(r * r);
        double tmp2 = x * Math.cos(r * r);

        return new Point(tmp1 - tmp2, tmp2 + tmp1);
    }
}
