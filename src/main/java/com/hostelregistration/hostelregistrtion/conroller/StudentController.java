package com.hostelregistration.hostelregistrtion.conroller;


import com.hostelregistration.hostelregistrtion.model.Student;
import com.hostelregistration.hostelregistrtion.repository.StudentRepository;
import com.hostelregistration.hostelregistrtion.services.MapValidationErrorService;
import com.hostelregistration.hostelregistrtion.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    Collection<Student> students(){

        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    ResponseEntity<?> getStudent(@PathVariable String id){
        Optional<Student> student =studentRepository.findById(id);
        return student.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PutMapping("/student")
    ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student){
        Student result= studentRepository.save(student);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/student/{id}")
    ResponseEntity<?> deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @RequestBody Student student,BindingResult result){
        System.out.println(result.hasErrors());

        if (result.hasErrors()) {

            List<String> errors = new ArrayList<String>();
            for (ObjectError res : result.getFieldErrors()) {
                errors.add(res.getDefaultMessage());
            }
            throw new RuntimeException(errors.toString());
        }

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Student newStudent = studentService.saveStudent(student);

        return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
    }

    }




