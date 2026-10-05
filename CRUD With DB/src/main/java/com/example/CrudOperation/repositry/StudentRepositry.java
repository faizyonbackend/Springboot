package com.example.CrudOperation.repositry;

import com.example.CrudOperation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepositry extends JpaRepository<Student,Long> {

}
