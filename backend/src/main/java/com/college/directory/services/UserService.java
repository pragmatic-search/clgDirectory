
package com.college.directory.service;

import com.college.directory.models.User;
import java.util.List;

public interface UserService {
  List<User> getAllUsers();
  User getUserById(Long id);
  User addUser(User user);
  User updateUser(Long id, User user);
  void deleteUser(Long id);
}
