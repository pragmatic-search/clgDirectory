
package com.college.directory.controller;

import com.college.directory.model.FacultyProfile;
import com.college.directory.model.StudentProfile;
import com.college.directory.payload.DashboardResponse;
import com.college.directory.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired private AdminService adminService;

  @GetMapping("/students")
  public List<StudentProfile> getAllStudents() {
    return adminService.getAllStudents();
  }

  @PostMapping("/students")
  public StudentProfile
  createStudent(@RequestBody StudentProfile studentProfile) {
    return adminService.createStudent(studentProfile);
  }

  @PutMapping("/students/{userId}")
  public StudentProfile
  updateStudent(@PathVariable Long userId,
                @RequestBody StudentProfile studentProfile) {
    return adminService.updateStudent(userId, studentProfile);
  }

  @DeleteMapping("/students/{userId}")
  public void deleteStudent(@PathVariable Long userId) {
    adminService.deleteStudent(userId);
  }

  @GetMapping("/faculty")
  public List<FacultyProfile> getAllFaculty() {
    return adminService.getAllFaculty();
  }

  @GetMapping("/dashboard")
  public DashboardResponse getDashboardData() {
    return adminService.getDashboardData();
  }
}
