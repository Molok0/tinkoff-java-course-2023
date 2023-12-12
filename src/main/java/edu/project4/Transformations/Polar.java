package edu.project4.Transformations;

import edu.project4.Models.Point;

public class Polar implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = Math.atan2(y, x) / Math.PI;
        double newY = Math.sqrt(x * x + y * y) - 1;

        return new Point(newX, newY);
    }
}
