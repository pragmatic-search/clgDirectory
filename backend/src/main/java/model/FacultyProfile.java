
package com.college.directory.model;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
public class FacultyProfile {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Column(nullable = false) private String name;

  @Column(nullable = false) private String department;

  @Column(nullable = false) private String email;

  @Column(nullable = false) private String phone;

  @Column(nullable = false) private String officeHours;

  public FacultyProfile() {}

  public FacultyProfile(String name, String department, String email,
                        String phone, String officeHours) {
    this.name = name;
    this.department = department;
    this.email = email;
    this.phone = phone;
    this.officeHours = officeHours;
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

  public String getOfficeHours() { return officeHours; }

  public void setOfficeHours(String officeHours) {
    this.officeHours = officeHours;
  }
}
