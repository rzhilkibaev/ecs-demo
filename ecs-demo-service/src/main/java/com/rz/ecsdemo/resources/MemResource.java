package com.rz.ecsdemo.resources;

import io.dropwizard.jersey.params.IntParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("mem")
public class MemResource {

    @GET
    @Path("/{amountMb}")
    public String consumeMemory(@PathParam("amountMb") IntParam amountMb) {
        System.out.println("Consuming: " + amountMb.get() + "Mb, free: " + getFreeMemoryMb());
        byte[][] megabytes = new byte[amountMb.get()][1024 * 1024];

        return "Consumed: " + megabytes.length + "Mb, free: " + getFreeMemoryMb();
    }

    private long getFreeMemoryMb() {
        return Runtime.getRuntime().freeMemory() / 1024;
    }

}

