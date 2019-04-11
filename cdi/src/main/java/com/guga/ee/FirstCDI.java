package com.guga.ee;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
/*
Some example from https://github.com/aboullaite/cdi2-javase
 */
public class FirstCDI {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        /** disable discovery and register classes manually */
        try (SeContainer container = initializer
                .disableDiscovery()
                .addPackages(Car.class, DateTimeProvider.class).initialize()) {
            final Car car = container.select(Car.class).get();
            final DateTimeProvider dateTimeProvider = container.select(DateTimeProvider.class).get();
            System.out.println("Fuel data");
            System.out.println("Quantitiy  -> "+car.getFuelQuantity());
            System.out.println("Checked at -> "+dateTimeProvider.getCurrentDateTimeInISO8601());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
