package edu.hw10.Task1.TestClass;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;

public record MyRecord(@Max(intValue = 20) @Min(intValue = 10) int age, double fl, String name,
                       @Min(intValue = 1000) long ag2) {
}
