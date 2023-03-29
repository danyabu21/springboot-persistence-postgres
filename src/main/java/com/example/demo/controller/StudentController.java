package com.example.demo.controller;

import com.example.demo.model.entity.Student;
import com.example.demo.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping
    public @ResponseBody Student setStudent(@RequestParam String name, String cpf, String birthdate) {
        Student student = new Student(name, cpf, birthdate);
        studentRepository.save(student);
        return student;
    }

    @GetMapping
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @PutMapping
    public Student editStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @DeleteMapping(path = "/{id}")
    public void removeStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
