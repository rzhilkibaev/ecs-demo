package com.rz.ecsdemo;

import com.rz.ecsdemo.resources.CpuResource;
import com.rz.ecsdemo.resources.MemResource;
import io.dropwizard.Application;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EcsDemoServiceApplication extends Application<EcsDemoServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EcsDemoServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "EcsDemoService";
    }

    @Override
    public void initialize(final Bootstrap<EcsDemoServiceConfiguration> bootstrap) {
        // do nothing
    }

    @Override
    public void run(final EcsDemoServiceConfiguration configuration, final Environment environment) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        environment.jersey().register(new MemResource());
        environment.jersey().register(new CpuResource(executorService));
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() throws Exception {
                // do nothing
            }

            @Override
            public void stop() throws Exception {
                executorService.shutdownNow();
            }
        });
    }

}
