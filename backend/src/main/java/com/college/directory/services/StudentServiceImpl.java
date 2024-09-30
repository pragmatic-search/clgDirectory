
package com.college.directory.service;

import com.college.directory.models.Student;
import com.college.directory.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired private StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public Student getStudentById(Long id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Override
  public Student addStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public Student updateStudent(Long id, Student student) {
    if (studentRepository.existsById(id)) {
      student.setId(id);
      return studentRepository.save(student);
    }
    return null;
  }

  @Override
  public void deleteStudent(Long id) {
    if (studentRepository.existsById(id)) {
      studentRepository.deleteById(id);
    }
  }
}
