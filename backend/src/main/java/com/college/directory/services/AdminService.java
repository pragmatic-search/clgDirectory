
package com.college.directory.service;

import com.college.directory.models.Admin;
import java.util.List;

public interface AdminService {
  List<Admin> getAllAdmins();
  Admin getAdminById(Long id);
  Admin addAdmin(Admin admin);
  Admin updateAdmin(Long id, Admin admin);
  void deleteAdmin(Long id);
}
