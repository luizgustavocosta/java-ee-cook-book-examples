package com.guga.ee;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class ServerMock {

    static final URI CONTEXT = URI.create("http://localhost:8080/");
    static final String BASE_PATH = "ssevents";

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            final ResourceConfig resourceConfig = new
                    ResourceConfig(SseResource.class);

            final HttpServer server =
                    GrizzlyHttpServerFactory.createHttpServer(CONTEXT,
                            resourceConfig, false);
            server.start();

            System.out.println(String.format("Mock Server started at %s%s", CONTEXT, BASE_PATH));
            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }
}
