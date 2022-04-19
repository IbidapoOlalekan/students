package com.example.demo.dtos.responses;

import com.example.demo.data.models.Gender;
import com.example.demo.data.models.Student;
import lombok.Data;

@Data
public class FindStudentResponse {
    private String fullName;
    private String email;
    private int age;
    private Gender gender;

    public FindStudentResponse(Student student){
        fullName = student.getLastName() + " " + student.getFirstName();
        email = student.getEmail();
        age = student.getAge();
    }
    public FindStudentResponse(){

    }

}
