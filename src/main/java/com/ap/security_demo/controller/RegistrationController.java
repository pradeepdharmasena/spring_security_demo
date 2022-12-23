package com.ap.security_demo.controller;

import com.ap.security_demo.entity.Users;
import com.ap.security_demo.event.RegistrationCompleteEvent;
import com.ap.security_demo.model.UserModel;
import com.ap.security_demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, HttpServletRequest request){
        Users users = userService.registerUser(userModel);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(users, applicationUrl(request)));
        return "success";
    }
    @GetMapping("/home")
    public String home(){

        return "Home Page app working fine";
    }

    private String applicationUrl(HttpServletRequest request) {

        return "http://"+ request.getServerName() + ":" +request.getServerPort() +
                request.getContextPath();
    }
}
