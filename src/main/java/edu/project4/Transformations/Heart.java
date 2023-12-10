package edu.project4.Transformations;

import edu.project4.Models.Point;

public class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.pow(x * x + y * y, 0.5);
        double tmp = r * Math.atan(y / x);

        return new Point(r * Math.sin(tmp), -r * Math.cos(tmp));
    }
}
