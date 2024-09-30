
package com.college.directory.service;

import com.college.directory.models.Faculty;
import java.util.List;

public interface FacultyService {
  List<Faculty> getAllFaculties();
  Faculty getFacultyById(Long id);
  Faculty addFaculty(Faculty faculty);
  Faculty updateFaculty(Long id, Faculty faculty);
  void deleteFaculty(Long id);
}
