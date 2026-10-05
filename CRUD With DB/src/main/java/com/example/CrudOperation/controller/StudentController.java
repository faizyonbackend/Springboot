package com.example.CrudOperation.controller;


import com.example.CrudOperation.entity.Student;
import com.example.CrudOperation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student create = studentService.creatStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);

    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentByid(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        if (student==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);

    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudentByid(){
        List<Student> studentAll = studentService.getAll();
        if (studentAll==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentAll);

    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestParam Long id ,
                                          @RequestBody Student studentreq){
        Student student = studentService.updateStudent(studentreq, id);
        if (student==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);

    }


}


