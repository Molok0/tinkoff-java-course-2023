package edu.project4.Processors;

import edu.project4.Models.FractalImage;

@FunctionalInterface
public
interface ImageProcessor {
    void process(FractalImage image);
}
