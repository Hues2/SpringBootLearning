package com.example.springboot.test.SpringBootTestApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service //--> Could also use @Component --> They do the exact same thing
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email already exists");
        }

        studentRepository.save(student);
    }

    public void removeStudent(Long studentId){
       boolean exists = studentRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("Student does not exist");
        }
        this.studentRepository.deleteById(studentId);
    }

}
