package edu.project4.Models;

public record Point(double x, double y) {
    public Point rotate(double theta2) {
        double cosAngle = Math.cos(theta2);
        double sinAngle = Math.sin(theta2);
        double newX =  x * cosAngle - y * sinAngle;
        double newY =  x * sinAngle + y * cosAngle;
        return new Point(newX, newY);
    }
}
