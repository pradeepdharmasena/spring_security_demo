package com.ap.security_demo.listners;

import com.ap.security_demo.entity.Users;
import com.ap.security_demo.event.RegistrationCompleteEvent;
import com.ap.security_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        Users user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        String url = event.getApplicationUrl() +
                "verifyingregistration?token=" +
                token;

        log.info("Click on the Link to verify : " + url);
    }
}
