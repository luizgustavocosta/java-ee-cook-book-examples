package com.guga.ee;

import javax.inject.Named;

@Named
public class Car {

    public double getFuelQuantity(){
        return Math.random();
    }
}
