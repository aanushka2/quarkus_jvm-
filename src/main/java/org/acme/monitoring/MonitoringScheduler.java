package org.acme.monitoring;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class MonitoringScheduler {
    private final JVMMetricsService metricsService = new JVMMetricsService();

    private static final int THREAD_COUNT_THRESHOLD = 10;

    @Scheduled(every = "10s") // Runs every 10 seconds
    public void monitorJvm() {
        long usedHeap = metricsService.getUsedHeapMemory();
        long maxHeap = metricsService.getMaxHeapMemory();
        int threadCount = metricsService.getThreadCount();

        System.out.println("Monitoring JVM...");
        System.out.printf("Heap Memory: %d/%d%n", usedHeap, maxHeap);
        System.out.printf("Thread Count: %d%n", threadCount);

        if (threadCount > THREAD_COUNT_THRESHOLD) {
            System.err.println("ALERT: High thread count!");
        }
    }
}
