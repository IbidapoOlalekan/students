package com.example.demo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;
    private int age;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
//    private List<String> favouriteSubjects;
//    private BigDecimal totalSpentInBooks;
//    private LocalDateTime created;
}
