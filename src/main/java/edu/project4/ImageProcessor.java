package edu.project4;

import edu.project4.Models.FractalImage;

@FunctionalInterface
public
interface ImageProcessor {
    void process(FractalImage image);
}
