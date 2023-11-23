package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public final class Task1 {
    private static final int HOW_ADD = 20;

    private Task1() {
    }

    public static int increment(int value) {
        AtomicInteger atomicInteger = new AtomicInteger(value);
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < HOW_ADD; i++) {
                atomicInteger.addAndGet(1);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < HOW_ADD; i++) {
                atomicInteger.addAndGet(1);
            }
        });
        Thread threadThree = new Thread(() -> {
            for (int i = 0; i < HOW_ADD; i++) {
                atomicInteger.addAndGet(1);
            }
        });
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {

        }
        return atomicInteger.get();
    }
}
