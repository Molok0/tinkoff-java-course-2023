package edu.project4.Renderers;

import edu.project4.Models.FractalImage;
import edu.project4.Models.Rect;
import edu.project4.Transformations.Transformation;
import java.util.List;

@FunctionalInterface
public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        int samples,
        short iterPerSample,
        long seed
    );
}
