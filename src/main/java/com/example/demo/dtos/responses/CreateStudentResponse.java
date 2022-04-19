package com.example.demo.dtos.responses;

import lombok.Data;

@Data
public class CreateStudentResponse {
    private String fullName;
    private String email;
    private int age;
}
