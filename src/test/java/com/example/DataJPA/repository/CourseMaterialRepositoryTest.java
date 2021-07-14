package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Course;
import com.example.DataJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository repository;

        Course course = Course.builder()
                .courseTitle("DSA")
                .courseCredit(4)
                .build();

        @Test
    public  void SaveCourseMaterial(){
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public  void printAllCourseMaterial(){
            List<CourseMaterial> courseMaterialList = repository.findAll();

            System.out.println("courseMaterials : " + courseMaterialList);
    }
}