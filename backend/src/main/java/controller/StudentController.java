
package com.college.directory.controller;

import com.college.directory.model.FacultyProfile;
import com.college.directory.model.StudentProfile;
import com.college.directory.service.FacultyService;
import com.college.directory.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  @Autowired private StudentService studentService;

  @Autowired private FacultyService facultyService;

  @GetMapping("/profile/{userId}")
  public StudentProfile getProfile(@PathVariable Long userId) {
    return studentService.getStudentProfile(userId);
  }

  @GetMapping("/search")
  public List<StudentProfile>
  searchStudents(@RequestParam String name,
                 @RequestParam(required = false) String department) {
    return studentService.searchStudents(name, department);
  }

  @GetMapping("/advisors/{userId}")
  public List<FacultyProfile> getFacultyAdvisors(@PathVariable Long userId) {
    return facultyService.getAdvisorsForStudent(userId);
  }
}
