package com.ap.security_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
}
