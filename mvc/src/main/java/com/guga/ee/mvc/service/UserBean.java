package com.guga.ee.mvc.service;

import com.guga.ee.mvc.domain.User;

import javax.ejb.Stateless;

@Stateless
public class UserBean {

    public User getUser() {
        return new User("Pepa pig", "pepa@pig.com");
    }
}
