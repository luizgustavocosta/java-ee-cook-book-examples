package com.guga.ee.mvc.controller;

import com.guga.ee.mvc.service.UserBean;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("userController")
public class UserController {

    //@Inject
    Models models;

    @Inject
    UserBean userBean;

    @GET
    public String user() {
        models.put("user", userBean.getUser());
        return "/user.jsp";
    }

}