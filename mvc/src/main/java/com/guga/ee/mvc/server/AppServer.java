package com.guga.ee.mvc.server;

import io.netty.channel.ChannelHandler;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@ApplicationScoped
public class AppServer {

    private static final int INET_PORT = 8080;

    @Inject
    private Logger logger;

    @Inject
    private ChannelHandler channelHandler;

    public void init(@Observes @Priority(Interceptor.Priority.APPLICATION - 100)
                     @Initialized(ApplicationScoped.class) Object init) throws Exception {
        logger.info(init.toString());
        start();
    }

    private void start() {
        Server server = new Server();
        try (ServerConnector connector = new ServerConnector(server)) {
            connector.setPort(8090);
            server.setConnectors(new Connector[]{connector});
            ServletHandler handler = new ServletHandler();
            server.setHandler(handler);

            ResourceHandler resource_handler = new ResourceHandler();
            resource_handler.setDirectoriesListed(true);
            resource_handler.setWelcomeFiles(new String[]{"index.html"});
            resource_handler.setResourceBase(".");
            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[]{resource_handler, new DefaultHandler()});
            server.setHandler(handlers);

            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
