package com.guga.ee.message;

public class MyRequest {

    private String name;

    public MyRequest() {
    }

    public MyRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
