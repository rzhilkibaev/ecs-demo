package com.rz.ecsdemo.resources;

import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("mem")
public class MemResource {

    @GET
    public void consumeMemory(@QueryParam("amountMb") Optional<Integer> amountMb) {
        System.out.println(amountMb.orElse(0));
    }
}
