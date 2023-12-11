package edu.project4.Models;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        var data = new Pixel[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                data[x][y] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new FractalImage(data,width, height);
    }

    boolean contains(int x, int y) {
        return false;
    }

    public Pixel pixel(int x, int y) {
        return data[x][y];
    }
}
