package com.kiran.madanwad.mongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    public void createNewStudent(Student student) {
        student.setCreated(LocalDateTime.now());
        studentRepository.insert(student);
    }

/*    public void updateNewStudent(Student student) {
        student.setCreated(LocalDateTime.now());
        studentRepository.
    }*/
}
