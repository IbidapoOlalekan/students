package com.example.demo.utils;

import com.example.demo.data.models.Address;
import com.example.demo.data.models.Student;
import com.example.demo.dtos.requests.CreateStudentRequest;
import com.example.demo.dtos.responses.CreateStudentResponse;
import com.example.demo.dtos.responses.FindStudentResponse;

import java.util.Optional;

public class ModelMapper {
    public static Student map(CreateStudentRequest request){
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());
        Address address = mapper(request);
        student.setAddress(address);
        student.setGender(request.getGender());

        return student;
    }

    public static Address mapper(CreateStudentRequest request){
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        return address;
    }


    public static CreateStudentResponse map(Student savedStudent) {
        CreateStudentResponse response = new CreateStudentResponse();
        response.setFullName(savedStudent.getLastName() + " " + savedStudent.getFirstName());
        response.setAge(savedStudent.getAge());
        response.setEmail(savedStudent.getEmail());
        return response;
    }



    public static FindStudentResponse maps(Student student){
        FindStudentResponse response = new FindStudentResponse();
        response.setFullName(student.getLastName() + " " + student.getFirstName());
        response.setEmail(student.getEmail());
        response.setAge(student.getAge());
        response.setGender(student.getGender());
        return response;
    }

}
