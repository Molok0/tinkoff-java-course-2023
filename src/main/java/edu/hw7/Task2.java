package edu.hw7;

import java.util.stream.LongStream;

public final class Task2 {

    private Task2() {
    }

    public static Long getMultithreadingFactorial(int number) {
        return LongStream.rangeClosed(1, number).parallel().reduce(1, (acc, element) -> acc * element);
    }
}
