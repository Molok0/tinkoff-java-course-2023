package edu.project4.Transformations;

import edu.project4.Models.Point;

public class Polar implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = Math.atan(y / x) / Math.PI;
        double newY = Math.pow(x * x + y * y, 0.5) - 1;

        return new Point(newX, newY);
    }
}
