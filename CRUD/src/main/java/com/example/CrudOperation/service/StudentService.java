package com.example.CrudOperation.service;


import com.example.CrudOperation.entity.Student;
import com.example.CrudOperation.repositry.StudentRepositry;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
   private StudentRepositry studentRepositry;

    public StudentService(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    public Student creatStudent(Student student){
        Student studentreq = studentRepositry.studentSave(student);
        return studentreq;
    }
}
