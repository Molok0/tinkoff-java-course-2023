package edu.project4;

import edu.project4.Models.AffineCoefficients;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Rect;
import edu.project4.Renderers.SingleThreadedRenderer;
import edu.project4.Transformations.AffineTransformation;
import edu.project4.Transformations.Disk;
import edu.project4.Transformations.Heart;
import edu.project4.Transformations.Polar;
import edu.project4.Transformations.Sinusoidal;
import edu.project4.Transformations.Spherical;
import edu.project4.Transformations.Swirl;
import edu.project4.Transformations.Transformation;
import java.util.List;

public class Main {
    public static void start() {
        FractalImage canvas = FractalImage.create(1920, 1080);

        List<AffineCoefficients> affineCoefficients = AffineTransformation.getCoeff();
        SingleThreadedRenderer renderer = new SingleThreadedRenderer(affineCoefficients, 1900, 1000);

        List<Transformation> transformations = List.of(
            new Polar(),
            new Heart(),
            new Disk(),
            new Sinusoidal(),
            new Spherical(),
            new Swirl()
        );
        Rect world = new Rect(-1.77, -1, 1.77, 1);
        var fractal = renderer.render(canvas, world, transformations, 200_000, (short) 1500, 10);
    }
}
