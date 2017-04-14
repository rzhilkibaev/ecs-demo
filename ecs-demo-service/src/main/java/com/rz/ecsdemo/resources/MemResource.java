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
        byte[][] megabytes = new byte[amountMb.get()][1024 * 1024];
        long freeMb = Runtime.getRuntime().freeMemory() / 1024;
        return "Consumed: " + megabytes.length + "Mb, free: " + freeMb;
    }
}

