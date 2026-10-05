package com.example.CrudOperation.service;


import com.example.CrudOperation.entity.Student;
import com.example.CrudOperation.repositry.StudentRepositry;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   private StudentRepositry studentRepositry;

    public StudentService(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    public Student creatStudent(Student student){
        Student studentreq = studentRepositry.save(student);
        return studentreq;
    }

    public Student getStudent(Long id){
        Optional<Student>received = studentRepositry.findById(id);
        return received.orElse(null);
    }

    public List<Student> getAll(){
        List<Student> studenttAll = studentRepositry.findAll();
        return studenttAll;
    }

    public Student updateStudent(Student student , Long id){
        Optional<Student>student1 = studentRepositry.findById(id);
        if (student1.isEmpty()){
            return null;
        }
        Student student2 = student1.get();
        student2.setName(student.getName());
        student2.setAge(student.getAge());
        student2.setEmail(student.getEmail());
        student2.setRollno(student.getRollno());
        student2.setSubject(student.getSubject());
        return studentRepositry.save(student2);
    }
}
