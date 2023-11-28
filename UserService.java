package com.group4.MentorConnect.service;

import com.group4.MentorConnect.model.User;
import com.group4.MentorConnect.repository.UserRepository;
import com.group4.MentorConnect.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Autowired
    public UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public void createUser(String email, String password, String role) {
        User user = userFactory.createUser(email, password, role);
        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
