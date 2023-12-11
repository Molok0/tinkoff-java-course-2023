package edu.project4;

import edu.project4.Models.AffineCoefficients;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Rect;
import edu.project4.Renderers.SingleThreadedRenderer;
import edu.project4.Save.ImageFormat;
import edu.project4.Save.ImageUtils;
import edu.project4.Transformations.AffineTransformation;
import edu.project4.Transformations.Disk;
import edu.project4.Transformations.Heart;
import edu.project4.Transformations.Polar;
import edu.project4.Transformations.Sinusoidal;
import edu.project4.Transformations.Spherical;
import edu.project4.Transformations.Swirl;
import edu.project4.Transformations.Transformation;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final int width = 1920;
    private static final int height = 1080;
    public static void start() {
        int width = 1920;
        int height = 1080;
        FractalImage canvas = FractalImage.create(width, height);

        List<AffineCoefficients> affineCoefficients = AffineTransformation.getCoeff();
        SingleThreadedRenderer renderer = new SingleThreadedRenderer(affineCoefficients);

        List<Transformation> transformations = List.of(
//            new Polar(),
            new Heart()
//            new Disk()
//            new Sinusoidal(),
//            new Spherical(),
//            new Swirl()
        );
        Rect world = new Rect(-1.77, -1, 1.77, 1);
        var fractal = renderer.render(canvas, world, transformations, 20000, (short) 1500, 10);
        ImageUtils.save(fractal, Path.of("C:\\Users\\dopro\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\project4\\1.jpg"), ImageFormat.JPEG);
    }

    public static void main(String[] args) {
        start();
    }
}
