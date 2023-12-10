package edu.project4.Save;

import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public final class ImageUtils {
    public static void save(FractalImage image, Path filename, ImageFormat format) {
        Pixel[][] pixel = image.data();
        int width = pixel[0].length;
        int height = pixel.length;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixelValue = pixel[y][x];
                int red = pixelValue.r();
                int green = pixelValue.g();
                int blue = pixelValue.b();

                int colorRGB = (red << 16) | (green << 8) | blue;
                bufferedImage.setRGB(x, y, colorRGB);
            }
        }

        File output = new File(filename.toUri());
        try {
            System.out.println(output);
            ImageIO.write(bufferedImage, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
