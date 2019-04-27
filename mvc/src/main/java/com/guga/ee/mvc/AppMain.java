package com.guga.ee.mvc;

import com.guga.ee.mvc.server.AppServer;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class AppMain {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try (SeContainer container = initializer
                .initialize()) {
            container.select(AppServer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
