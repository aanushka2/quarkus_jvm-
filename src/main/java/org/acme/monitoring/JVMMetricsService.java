package org.acme.monitoring;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

public class JVMMetricsService {
    private final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public long getUsedHeapMemory() {
        return memoryMXBean.getHeapMemoryUsage().getUsed();
    }

    public long getMaxHeapMemory() {
        return memoryMXBean.getHeapMemoryUsage().getMax();
    }

    public int getThreadCount() {
        return threadMXBean.getThreadCount();
    }

    public double getSystemCpuLoad() {
        return ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
    }
}
