package com.example.demo.controller;

import com.example.demo.dtos.requests.CreateStudentRequest;
import com.example.demo.dtos.responses.ApiResponse;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.services.CreateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private CreateStudentService createStudentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequest request){
        try {
            return new ResponseEntity<>(createStudentService.create(request),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        try {
            return new ResponseEntity<>(createStudentService.findAllStudent(),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/FirstName/{keyword}")
    public ResponseEntity<?> getStudentByFirstName(@PathVariable("keyword") String firstName){
        try {
            return new ResponseEntity<>(createStudentService.findStudentByFirstName(firstName),HttpStatus.OK);
        }
        catch(StudentNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/LastName/{keyword}")
    public ResponseEntity<?> getStudentByLastName(@PathVariable("keyword") String lastName){
        try {
            return new ResponseEntity<>(createStudentService.findStudentByLastName(lastName),HttpStatus.OK);
        }
        catch(StudentNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
