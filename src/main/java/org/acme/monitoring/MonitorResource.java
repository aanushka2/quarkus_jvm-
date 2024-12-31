package org.acme.monitoring;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/monitor")
public class MonitorResource {
    private final JVMMetricsService metricsService = new JVMMetricsService();

    @GET
    @Path("/metrics")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMetrics() {
        return String.format(
                "{\"usedHeapMemory\": %d, \"maxHeapMemory\": %d, \"threadCount\": %d, \"cpuLoad\": %.2f}",
                metricsService.getUsedHeapMemory(),
                metricsService.getMaxHeapMemory(),
                metricsService.getThreadCount(),
                metricsService.getSystemCpuLoad() * 100
        );
    }
}
