
package com.college.directory.controller;

import com.college.directory.model.FacultyProfile;
import com.college.directory.model.StudentProfile;
import com.college.directory.service.FacultyService;
import com.college.directory.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

  @Autowired private FacultyService facultyService;

  @Autowired private StudentService studentService;

  @GetMapping("/profile/{userId}")
  public FacultyProfile getProfile(@PathVariable Long userId) {
    return facultyService.getFacultyProfile(userId);
  }

  @PutMapping("/profile/update/{userId}")
  public FacultyProfile
  updateProfile(@PathVariable Long userId,
                @RequestBody FacultyProfile facultyProfile) {
    return facultyService.updateFacultyProfile(userId, facultyProfile);
  }

  @GetMapping("/students/{courseId}")
  public List<StudentProfile> getStudentsInCourse(@PathVariable Long courseId) {
    return studentService.getStudentsByCourse(courseId);
  }
}
