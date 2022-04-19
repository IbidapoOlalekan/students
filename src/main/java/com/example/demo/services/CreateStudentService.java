package com.example.demo.services;

import com.example.demo.data.models.Student;
import com.example.demo.dtos.requests.CreateStudentRequest;
import com.example.demo.dtos.responses.CreateStudentResponse;
import com.example.demo.dtos.responses.FindStudentResponse;
import org.apache.el.stream.Optional;

import java.util.List;

public interface CreateStudentService {
    CreateStudentResponse create(CreateStudentRequest request);
    FindStudentResponse findStudentByFirstName(String firstName);
    FindStudentResponse findStudentByLastName(String lastName);
    void deleteStudent(CreateStudentRequest request);
    List<Student> findAllStudent();
    FindStudentResponse findStudentByEmail(String email);
}
