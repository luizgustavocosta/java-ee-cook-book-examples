package com.guga.javaee;


import javax.validation.Payload;

public class Severity {

    public static class Info implements Payload{};
    public static class Error implements Payload{};
}
