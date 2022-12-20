package com.ap.security_demo.controller;

import com.ap.security_demo.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(RegistrationController.class)
class RegistrationControllerTest {
    @Autowired
    private RegistrationController registrationController;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveUser(){
        UserModel userModel = UserModel.builder()
                .email("asanaka@gmail.com")
                .firstName("Asanka")
                .lastName("Pradeep")
                .password("1234")
                .confirmPassword("1234")
                .build();
        String out = registrationController.registerUser(userModel);
        System.out.println("User Registration ===> " + out);
    }
}