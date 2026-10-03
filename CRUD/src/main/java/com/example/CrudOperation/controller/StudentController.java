package com.example.CrudOperation.controller;


import com.example.CrudOperation.entity.Student;
import com.example.CrudOperation.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        studentService.creatStudent(student);
        return "Student Created";

    }

    public void getStudent(){

    }
}
