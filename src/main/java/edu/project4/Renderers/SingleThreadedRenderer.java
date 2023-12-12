package edu.project4.Renderers;

import edu.project4.Models.AffineCoefficients;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;
import edu.project4.Models.Point;
import edu.project4.Models.Rect;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.Random;

public class SingleThreadedRenderer implements Renderer {

    private final List<AffineCoefficients> coefficients;

    private static final double SYMMETRY = 1;

    public SingleThreadedRenderer(List<AffineCoefficients> coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public FractalImage render(
        FractalImage canvas, Rect world, List<Transformation> variations, int samples, short iterPerSample, long seed
    ) {
        Random random = new Random();
        double xMin = world.x();
        double xMax = world.width();
        double yMin = world.y();
        double yMax = world.height();
        for (int num = 0; num < samples; ++num) {
            double newX = random.nextDouble(xMin, xMax);
            double newY = random.nextDouble(yMin, yMax);
            Point pw = new Point(newX, newY);

            for (short step = 0; step < iterPerSample; ++step) {

                int i = random.nextInt(0, coefficients.size());
                double x =
                    coefficients.get(i).a() * pw.x() + coefficients.get(i).b() * pw.y() + coefficients.get(i).c();
                double y =
                    coefficients.get(i).d() * pw.x() + coefficients.get(i).e() * pw.y() + coefficients.get(i).f();

                Transformation variation = variations.get(random.nextInt(0, variations.size()));

                pw = variation.apply(new Point(x, y));

                double theta2 = 0.0;

                for (int s = 0; s < SYMMETRY; theta2 += Math.PI * 2 / SYMMETRY, ++s) {

                    var pwr = pw.rotate(theta2);

                    int ansX = (int) (canvas.width() - ((xMax - pwr.x()) / (xMax - xMin)) * canvas.width());
                    int ansY = (int) (canvas.height() - ((yMax - pwr.y()) / (yMax - yMin)) * canvas.height());

                    if (ansX < canvas.width() && ansY < canvas.height() && ansX > 0 && ansY > 0) {
                        Pixel pixel = canvas.pixel(ansY, ansX);

                        if (pixel.hitCount() == 0) {
                            canvas.data()[ansY][ansX] =
                                new Pixel(
                                    coefficients.get(i).rr(),
                                    coefficients.get(i).gg(),
                                    coefficients.get(i).bb(),
                                    1,
                                    canvas.data()[ansY][ansX].normal()
                                );
                        } else {
                            canvas.data()[ansY][ansX] =
                                new Pixel(
                                    (coefficients.get(i).rr() + pixel.r()) / 2,
                                    (coefficients.get(i).gg() + pixel.g()) / 2,
                                    (coefficients.get(i).bb() + pixel.b()) / 2,
                                    pixel.hitCount() + 1,
                                    canvas.data()[ansY][ansX].normal()
                                );
                        }
                    }
                }
            }
        }
        return canvas;
    }
}
