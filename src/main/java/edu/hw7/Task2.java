package edu.hw7;

import java.util.stream.LongStream;

public final class Task2 {

    private Task2() {
    }

    public static Long getMultithreadingFactorial(int number) {
        return LongStream.rangeClosed(1, number).boxed().toList().parallelStream()
            .reduce(1L, (acc, element) -> acc * element);
    }
}
