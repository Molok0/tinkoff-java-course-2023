package edu.project4.Processors;

import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class GammaCorrectionProcessor implements ImageProcessor {

    private static final double GAMMA = 2.2;

    @Override
    public void process(FractalImage image) {
        double max = 0.0;
        for (int row = 0; row < image.width(); row++) {
            for (int col = 0; col < image.height(); col++) {
                var px = image.data()[col][row];
                if (px.hitCount() != 0) {
                    double normal = log10(px.hitCount());
                    if (normal > max) {
                        max = normal;
                    }
                    image.data()[col][row] = new Pixel(px.r(), px.g(), px.b(), px.hitCount(), normal);
                }
            }
        }
        for (int row = 0; row < image.width(); row++) {
            for (int col = 0; col < image.height(); col++) {
                var px = image.data()[col][row];
                double normal = px.normal() / max;
                int r = (int) (px.r() * pow(px.normal(), (1.0 / GAMMA)));
                int g = (int) (px.g() * pow(px.normal(), (1.0 / GAMMA)));
                int b = (int) (px.b() * pow(px.normal(), (1.0 / GAMMA)));
                image.data()[col][row] = new Pixel(r, g, b, px.hitCount(), normal);
            }
        }
    }
}
