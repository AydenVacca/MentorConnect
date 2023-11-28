package com.group4.MentorConnect.repository;

import com.group4.MentorConnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
// other necessary imports...

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
