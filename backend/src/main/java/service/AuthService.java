
package com.college.directory.service;

import com.college.directory.model.User;
import com.college.directory.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  public Optional<User> login(String username, String password) {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isPresent() &&
        passwordEncoder.matches(password, user.get().getPassword())) {
      return user; // Successful authentication
    }
    return Optional.empty(); // Invalid credentials
  }

  public User register(User newUser) {
    newUser.setPassword(passwordEncoder.encode(
        newUser.getPassword())); // Encrypt password before saving
    return userRepository.save(newUser);
  }
}
