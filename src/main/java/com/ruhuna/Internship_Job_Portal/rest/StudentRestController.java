package com.ruhuna.Internship_Job_Portal.rest;

import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.Student;
import com.ruhuna.Internship_Job_Portal.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("api/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = studentService.findStudentById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("api/students")
    public void signUpStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @PostMapping("api/students/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Student student = studentService.findByEmail(loginRequest.getEmail(), loginRequest.getPassword());
            return (ResponseEntity<?>) ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
