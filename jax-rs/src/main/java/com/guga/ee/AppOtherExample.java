package com.guga.ee;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.RuntimeDelegate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class AppOtherExample {
    public static void main(String[] args) {

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(GreetingsResource.class);

        HttpHandler handler = RuntimeDelegate.getInstance()
                .createEndpoint(resourceConfig, HttpHandler.class);

        HttpServer server = HttpServer.createSimpleServer(null, 8080);
        server.getServerConfiguration().addHttpHandler(handler);

        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Path("/greetings")
    public static class GreetingsResource {

        @GET
        public String getGreeting(){
            return "Hello world at "+LocalDateTime.now(ZoneOffset.UTC);
        }
    }

}
