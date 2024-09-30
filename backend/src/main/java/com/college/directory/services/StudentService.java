
package com.college.directory.service;

import com.college.directory.models.Student;
import java.util.List;

public interface StudentService {
  List<Student> getAllStudents();
  Student getStudentById(Long id);
  Student addStudent(Student student);
  Student updateStudent(Long id, Student student);
  void deleteStudent(Long id);
}
