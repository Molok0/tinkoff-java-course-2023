package edu.project4.Transformations;

import edu.project4.Models.Point;

public class Disk implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);
        double tmp1 = (1 / Math.PI) * Math.atan2(y, x);
        double tmp2 = Math.PI * r;

        return new Point(tmp1 * Math.sin(tmp2), tmp1 * Math.cos(tmp2));
    }
}
