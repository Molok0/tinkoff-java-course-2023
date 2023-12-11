package edu.project4.Models;

import java.util.Random;

public record Rect(double x, double y, double width, double height) {
    public boolean contains(Point p) {
        return false;
    }

}
