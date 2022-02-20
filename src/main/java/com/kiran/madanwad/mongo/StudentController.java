package com.kiran.madanwad.mongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createNewStudent(@RequestBody Student student) {
        studentService.createNewStudent(student);
        return student;
    }

    @PutMapping
    public Student updateNewStudent(@RequestBody Student student) {
        //studentService.updateNewStudent(student);
        return student;
    }
}
