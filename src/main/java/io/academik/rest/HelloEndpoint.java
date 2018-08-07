package io.academik.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("hello")
public class HelloEndpoint {

    @GET
    public String ping() {
        return "Hello from Java EE 8!";
    }

}
