package com.ap.security_demo.controller;

import com.ap.security_demo.entity.Users;
import com.ap.security_demo.model.UserModel;
import com.ap.security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        Users users = userService.registerUser(userModel);
        return "success";
    }
}
