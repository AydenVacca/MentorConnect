package com.group4.MentorConnect.factory;

import com.group4.MentorConnect.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public User createUser(String email, String password, String role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Note: In real applications, encrypt the password
        user.setRole(role);
        return user;
    }
}
