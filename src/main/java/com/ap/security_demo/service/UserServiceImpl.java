package com.ap.security_demo.service;

import com.ap.security_demo.config.WebSecurityConfig;
import com.ap.security_demo.entity.Users;
import com.ap.security_demo.entity.VerificationToken;
import com.ap.security_demo.model.UserModel;
import com.ap.security_demo.repository.UserRepository;
import com.ap.security_demo.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WebSecurityConfig webSecurityConfig;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Override
    public Users registerUser(UserModel userModel) {
        Users user = new Users();
        user.setEmail(userModel.getEmail());
        user.setPassword(webSecurityConfig.passwordEncoder().encode(userModel.getPassword()));
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, Users user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }
}
