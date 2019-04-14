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
                .addPackages(Package.getPackage("com.guga.ee"))
                .initialize()) {
            final Car car = container.select(Car.class).get();
            final DateTimeProvider dateTimeProvider = container.select(DateTimeProvider.class).get();
            final CountryRepository countryRepository = container.select(CountryRepository.class).get();
            final CityRepository cityRepository = container.select(CityRepository.class).get();
            System.out.println("Fuel data");
            System.out.format("%-15s:%2s%.3f%n", "Quantity", "",car.getFuelQuantity());
            System.out.format("%-15s:%2s%s%n", "Checked at", "",dateTimeProvider.getCurrentDateTimeInISO8601());
            System.out.format("%-15s:%2s%s%n", "From", "",cityRepository.findOneRandom());
            System.out.println("With this fuel you can arrive at "+countryRepository.findOneRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
