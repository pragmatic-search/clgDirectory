
package com.college.directory.service;

import com.college.directory.models.Faculty;
import com.college.directory.repository.FacultyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

  @Autowired private FacultyRepository facultyRepository;

  @Override
  public List<Faculty> getAllFaculties() {
    return facultyRepository.findAll();
  }

  @Override
  public Faculty getFacultyById(Long id) {
    return facultyRepository.findById(id).orElse(null);
  }

  @Override
  public Faculty addFaculty(Faculty faculty) {
    return facultyRepository.save(faculty);
  }

  @Override
  public Faculty updateFaculty(Long id, Faculty faculty) {
    if (facultyRepository.existsById(id)) {
      faculty.setId(id);
      return facultyRepository.save(faculty);
    }
    return null;
  }

  @Override
  public void deleteFaculty(Long id) {
    if (facultyRepository.existsById(id)) {
      facultyRepository.deleteById(id);
    }
  }
}
