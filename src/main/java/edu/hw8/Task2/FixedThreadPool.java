package edu.hw8.Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;

    private FixedThreadPool(int threadCount) {
        this.threads = new Thread[threadCount];
        this.queue = new LinkedBlockingQueue<>(threadCount);
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    @Override
    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void close() throws Exception {
        for (Thread thread : threads) {
            thread.interrupt();
        }

    }

    public static FixedThreadPool create(int threadCount) {
        return new FixedThreadPool(threadCount);
    }
}
