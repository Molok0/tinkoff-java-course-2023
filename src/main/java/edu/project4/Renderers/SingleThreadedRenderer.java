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

    private final List<AffineCoefficients> COEFFICIENTS;
    private static final double xMin = -1.777;
    private static final double xMax = 1.777;
    private static final double yMin = -1;
    private static final double yMax = 1;
    private static final double symmetry = 2;
    private final int xRes;
    private final int yRes;

    public SingleThreadedRenderer(List<AffineCoefficients> coefficients, int xRes, int yRes) {
        this.COEFFICIENTS = coefficients;
        this.xRes = xRes;
        this.yRes = yRes;
    }

    @Override
    public FractalImage render(
        FractalImage canvas, Rect world, List<Transformation> variations, int samples, short iterPerSample, long seed
    ) {
        Random random = new Random();
        for (int num = 0; num < samples; ++num) {
            double newX = random.nextDouble(xMin, xMax);
            double newY = random.nextDouble(yMin, yMax);
            Point pw = new Point(newX, newY);

            for (short step = 0; step < iterPerSample; ++step) {

                int i = random.nextInt(0, COEFFICIENTS.size());
                double x =
                    COEFFICIENTS.get(i).a() * pw.x() + COEFFICIENTS.get(i).b() * pw.y() + COEFFICIENTS.get(i).c();
                double y =
                    COEFFICIENTS.get(i).d() * pw.x() + COEFFICIENTS.get(i).e() * pw.y() + COEFFICIENTS.get(i).f();

                Transformation variation = variations.get(random.nextInt(0, variations.size()));

                pw = variation.apply(new Point(x, y));

                double theta2 = 0.0;

                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {

                    var pwr = pw.rotate(theta2);

                    int ansX = (int) (xRes - ((xMax - pwr.x())) / (xMax - xMin)) * xRes;
                    int ansY = (int) (yRes - ((yMax - pwr.y())) / (yMax - yMin)) * yRes;

                    if (ansX < xRes && ansY < yRes && ansX > 0 && ansY > 0) {
                        Pixel pixel = canvas.pixel(ansX, ansY);
                        if (pixel.hitCount() == 0) {
                            canvas.data()[ansX][ansY] =
                                new Pixel(
                                    COEFFICIENTS.get(i).rr(),
                                    COEFFICIENTS.get(i).gg(),
                                    COEFFICIENTS.get(i).bb(),
                                    1
                                );
                        } else {
                            canvas.data()[ansX][ansY] =
                                new Pixel(
                                    (COEFFICIENTS.get(i).rr() + pixel.r()) / 2,
                                    (COEFFICIENTS.get(i).gg() + pixel.g()) / 2,
                                    (COEFFICIENTS.get(i).bb() + pixel.b()) / 2,
                                    pixel.hitCount() + 1
                                );
                        }
                    }

                    // 1. делаем лок на время работы с пикселем
                    // 2. подмешиваем цвет и увеличиваем hit count
                }
            }
        }
        return canvas;
    }
}
