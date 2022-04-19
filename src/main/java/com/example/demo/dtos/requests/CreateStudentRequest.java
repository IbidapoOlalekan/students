package com.example.demo.dtos.requests;

import com.example.demo.data.models.Address;
import com.example.demo.data.models.Gender;
import lombok.Data;

@Data
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String country;
    private String city;
    private String postalCode;
    private Gender gender;
}
