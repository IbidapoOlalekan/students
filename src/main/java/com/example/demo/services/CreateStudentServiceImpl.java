package com.example.demo.services;

import com.example.demo.data.models.Address;
import com.example.demo.data.models.Student;
import com.example.demo.data.repositories.StudentRepository;
import com.example.demo.dtos.requests.CreateStudentRequest;
import com.example.demo.dtos.responses.CreateStudentResponse;
import com.example.demo.dtos.responses.FindStudentResponse;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreateStudentServiceImpl implements CreateStudentService{
    @Autowired
    public StudentRepository studentRepository;

    @Override
    public CreateStudentResponse create(CreateStudentRequest request) {
        Student student = ModelMapper.map(request);
        Student savedStudent = studentRepository.save(student);
        return ModelMapper.map(savedStudent);
    }

    @Override
    public FindStudentResponse findStudentByFirstName(String firstName) {
        Student student = studentRepository.findStudentByFirstName(firstName);
        if (student == null) throw getStudentNotFoundException("Student With " + firstName + " Cannot Be Found");
        return ModelMapper.maps(student);
    }

    @Override
    public FindStudentResponse findStudentByLastName(String lastName) {
        Student student = studentRepository.findStudentByLastName(lastName);
        if (student == null) throw getStudentNotFoundException("Student Cannot Be Found !!!!!");
        return ModelMapper.maps(student);
    }

    @Override
    public void deleteStudent(CreateStudentRequest request) {
        Student student = new Student(request.getFirstName(), request.getLastName(), request.getAge(), request.getEmail(), request.getGender(),ModelMapper.mapper(request));
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public FindStudentResponse findStudentByEmail(String email) {
        Student student = studentRepository.findStudentByEmail(email);
        if (student==null) throw getStudentNotFoundException("Student with email " + email + " not found");
//        Student student = studentRepository.findStudentByEmail(email).ifPresentOrElse(s ->{
//            System.out.println("Student Already Exists");
//        },()->{
//            studentRepository.insert(student);
//        });
        return ModelMapper.maps(student);
    }


    private StudentNotFoundException getStudentNotFoundException(String message) {
        return new StudentNotFoundException(message);
    }
}
