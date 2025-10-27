package fr.takima.training.simpleapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students", schema = "public")
public class Student {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  @Column(name="first_name", nullable = false, length = 20)
  private String firstName;

  @Column(name="last_name", nullable = false, length = 20)
  private String lastName;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Department getDepartment() { return department; }
  public void setDepartment(Department department) { this.department = department; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
}
