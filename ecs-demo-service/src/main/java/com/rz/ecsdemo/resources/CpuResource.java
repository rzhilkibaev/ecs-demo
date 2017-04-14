package com.rz.ecsdemo.resources;

import io.dropwizard.jersey.params.IntParam;
import io.dropwizard.jersey.params.LongParam;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("cpu")
public class CpuResource {

    private final ExecutorService executorService;

    public CpuResource(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @GET
    @Path("/{threads}/{durationMs}")
    public String consumeMemory(@PathParam("threads") IntParam threads, @PathParam("durationMs") LongParam durationMs) {
        System.out.println("Starting " + threads.get() + " threads on " + Runtime.getRuntime().availableProcessors() + " available processors");
        for (int i = 0; i < threads.get(); i++) {
            executorService.submit(new BusyTask(durationMs.get()));
        }
        return "Started " + threads.get() + "threads on " + Runtime.getRuntime().availableProcessors() + " available processors";
    }

    private static final class BusyTask implements Runnable {

        private final long durationMs;

        private BusyTask(long durationMs) {
            this.durationMs = durationMs;
        }

        @Override
        public void run() {
            long startTimeMs = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTimeMs < durationMs) ;
        }
    }
}

