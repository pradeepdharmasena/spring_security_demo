package com.ap.security_demo.event;

import com.ap.security_demo.entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private Users user;
    private String applicationUrl;

    public RegistrationCompleteEvent(Users user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;

    }
}
