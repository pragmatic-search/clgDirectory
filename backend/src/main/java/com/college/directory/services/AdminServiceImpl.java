
package com.college.directory.service;

import com.college.directory.models.Admin;
import com.college.directory.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired private AdminRepository adminRepository;

  @Override
  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  @Override
  public Admin getAdminById(Long id) {
    return adminRepository.findById(id).orElse(null);
  }

  @Override
  public Admin addAdmin(Admin admin) {
    return adminRepository.save(admin);
  }

  @Override
  public Admin updateAdmin(Long id, Admin admin) {
    if (adminRepository.existsById(id)) {
      admin.setId(id);
      return adminRepository.save(admin);
    }
    return null;
  }

  @Override
  public void deleteAdmin(Long id) {
    if (adminRepository.existsById(id)) {
      adminRepository.deleteById(id);
    }
  }
}
