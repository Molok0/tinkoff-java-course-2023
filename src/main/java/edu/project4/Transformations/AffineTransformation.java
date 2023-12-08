package edu.project4.Transformations;

import edu.project4.Models.Point;
import org.jetbrains.annotations.NotNull;
import java.util.function.Function;

public class AffineTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        return null;
    }

    @NotNull
    @Override
    public <V> Function<V, Point> compose(@NotNull Function<? super V, ? extends Point> before) {
        return Transformation.super.compose(before);
    }

    @NotNull
    @Override
    public <V> Function<Point, V> andThen(@NotNull Function<? super Point, ? extends V> after) {
        return Transformation.super.andThen(after);
    }
}
