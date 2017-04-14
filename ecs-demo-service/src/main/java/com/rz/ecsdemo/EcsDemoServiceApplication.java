package com.rz.ecsdemo;

import com.rz.ecsdemo.resources.MemResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final EcsDemoServiceConfiguration configuration, final Environment environment) {
        environment.jersey().register(new MemResource());
    }

}
