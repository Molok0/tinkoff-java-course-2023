package edu.project4.Save;

import edu.project4.Models.FractalImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public final class ImageUtils {
    private ImageUtils() {
    }

    void save(FractalImage image, Path filename, ImageFormat format) {
        int width = image.data()[0].length;
        int height = image.data().length;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        File output = new File(filename.toUri());
        try {
            ImageIO.write(bufferedImage, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
