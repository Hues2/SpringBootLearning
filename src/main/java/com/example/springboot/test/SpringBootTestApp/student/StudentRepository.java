package com.example.springboot.test.SpringBootTestApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // --> Responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {



}
