package com.guga.ee;

public class City {

    private int id;
    private String name;
    private String state;
    private String region;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
