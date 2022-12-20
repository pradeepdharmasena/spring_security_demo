package com.ap.security_demo.service;

import com.ap.security_demo.entity.Users;
import com.ap.security_demo.model.UserModel;

public interface UserService {
    Users registerUser(UserModel userModel);
}
