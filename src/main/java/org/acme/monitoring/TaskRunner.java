package org.acme.monitoring;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                long end = System.currentTimeMillis() + 2000; // Simulates work for 2 seconds
                while (System.currentTimeMillis() < end) {
                    Math.pow(Math.random(), Math.random());
                }
                System.out.println("Task completed by: " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
