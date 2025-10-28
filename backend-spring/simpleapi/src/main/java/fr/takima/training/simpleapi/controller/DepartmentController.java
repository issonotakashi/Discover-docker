package fr.takima.training.simpleapi.controller;

import fr.takima.training.simpleapi.model.Department;
import fr.takima.training.simpleapi.model.Student;
import fr.takima.training.simpleapi.repository.DepartmentRepository;
import fr.takima.training.simpleapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  private final StudentRepository studentRepository;
  private final DepartmentRepository departmentRepository;

  public DepartmentController(StudentRepository studentRepository,
                              DepartmentRepository departmentRepository) {
    this.studentRepository = studentRepository;
    this.departmentRepository = departmentRepository;
  }

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }

  @GetMapping("/{name}/students")
  public List<Student> studentsByDepartment(@PathVariable String name) {
    return studentRepository.findByDepartment_Name(name);
  }
}
