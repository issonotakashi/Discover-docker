package fr.takima.training.simpleapi.controller;

import fr.takima.training.simpleapi.model.Student;
import fr.takima.training.simpleapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

  private final StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping("/students")
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
