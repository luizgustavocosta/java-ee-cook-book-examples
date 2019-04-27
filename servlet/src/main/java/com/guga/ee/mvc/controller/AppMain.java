package com.guga.ee.mvc.controller;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class AppMain {

    public static void main(String... args) throws Exception {
        Server server = new Server();
        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(8090);
            server.setConnectors(new Connector[]{connector});
            ServletHandler handler = new ServletHandler();
            server.setHandler(handler);
            handler.addServletWithMapping(ServerSentEvent.class, "/ServerPush");
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
