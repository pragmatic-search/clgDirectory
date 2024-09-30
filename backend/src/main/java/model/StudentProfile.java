
package com.college.directory.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentProfile {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(nullable = false) private String name;

  @Column(nullable = false) private String department;

  @Column(nullable = false) private String email;

  @Column(nullable = false) private String phone;

  // Optional: Add more fields like GPA, courses, etc.

  public StudentProfile() {}

  public StudentProfile(String name, String department, String email,
                        String phone) {
    this.name = name;
    this.department = department;
    this.email = email;
    this.phone = phone;
  }

  // Getters and Setters

  public Long getId() { return id; }

  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getDepartment() { return department; }

  public void setDepartment(String department) { this.department = department; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  public String getPhone() { return phone; }

  public void setPhone(String phone) { this.phone = phone; }
}
