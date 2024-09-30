
package com.college.directory.controller;

import com.college.directory.model.User;
import com.college.directory.payload.LoginRequest;
import com.college.directory.payload.LoginResponse;
import com.college.directory.security.JwtTokenProvider;
import com.college.directory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired private UserService userService;

  @Autowired private JwtTokenProvider tokenProvider;

  @PostMapping("/login")
  public ResponseEntity<?>
  authenticateUser(@RequestBody LoginRequest loginRequest) {
    User user = userService.authenticate(loginRequest.getUsername(),
                                         loginRequest.getPassword());

    if (user == null) {
      return ResponseEntity.badRequest().body("Invalid credentials");
    }

    String jwt = tokenProvider.generateToken(user);
    return ResponseEntity.ok(new LoginResponse(jwt, user.getRole()));
  }
}
