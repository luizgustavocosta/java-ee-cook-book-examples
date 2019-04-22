package com.guga.ee.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Component
@Scope("view")
public class UserBean implements Serializable {

    private User user;
    private ZonedDateTime now;

    public UserBean(){
        user = new User("John Connor", "john.connor@terminator.com");
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getNow() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }
}
