package edu.project4;

import edu.project4.Models.AffineCoefficients;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Rect;
import edu.project4.Processors.GammaCorrectionProcessor;
import edu.project4.Renderers.SingleThreadedRenderer;
import edu.project4.Save.ImageFormat;
import edu.project4.Save.ImageUtils;
import edu.project4.Transformations.AffineTransformation;
import edu.project4.Transformations.Disk;
import edu.project4.Transformations.Transformation;
import java.nio.file.Path;
import java.util.List;

public class Starter {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    private static final int SAMPLES = 20_000;
    private static final short ITER_PER_SAMPLE = 1500;
    private static final long SEED = 10;
    private static final double X_MIN_RECT = -1.77;
    private static final double WIDTH_RECT = 1.77;
    private static final double Y_MIN_RECT = -1;
    private static final double HEIGHT_RECT = 1;

    private Starter() {
    }

    public static void start() {
        FractalImage canvas = FractalImage.create(WIDTH, HEIGHT);

        List<AffineCoefficients> affineCoefficients = AffineTransformation.getCoeff();
        SingleThreadedRenderer renderer = new SingleThreadedRenderer(affineCoefficients);

        List<Transformation> transformations = List.of(
//            new Polar()
//            new Heart()
            new Disk()
//            new Sinusoidal()
//            new Spherical()
//            new Swirl()
        );
        Rect world = new Rect(X_MIN_RECT, Y_MIN_RECT, WIDTH_RECT, HEIGHT_RECT);
        var fractal = renderer.render(canvas, world, transformations, SAMPLES, ITER_PER_SAMPLE, SEED);
        GammaCorrectionProcessor gammaCorrectionProcessor = new GammaCorrectionProcessor();
        gammaCorrectionProcessor.process(fractal);
        ImageUtils.save(
            fractal,
            Path.of("C:\\Users\\dopro\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\project4\\1.bmp"),
            ImageFormat.BMP
        );
    }

}
