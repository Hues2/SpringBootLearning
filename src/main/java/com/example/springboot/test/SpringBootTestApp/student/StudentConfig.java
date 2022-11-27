package com.example.springboot.test.SpringBootTestApp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        System.out.println("Running BEAN");
        return args -> {
            Student tom = new Student(1L,
                    "Tom",
                    "tom@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY, 23),
                    22);
            Student john = new Student("John", "jhon@gmail.com",
                    LocalDate.of(1999, Month.MARCH, 13), 23);

            studentRepository.saveAll(List.of(tom, john));
        };
    }

}
