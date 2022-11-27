package com.example.springboot.test.SpringBootTestApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // --> Responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("Select s FROM Student s WHERE s.email = ?1") // --> Not needed, as the method name is findStudentByEmail
    Optional<Student> findStudentByEmail(String email);

}
