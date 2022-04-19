package com.example.demo.data.repositories;

import com.example.demo.data.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    Student findStudentByEmail(String email);
    List<Student> findStudentByFirstNameOrLastName(String name);
    Student findStudentByFirstName(String firstName);
    Student findStudentByLastName(String lastName);
}
