package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Course;
import com.example.DataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private  TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course compiler = Course.builder()
                .courseTitle("Compiler")
                .courseCredit(4)
                .build();

        Course fop = Course.builder()
                .courseTitle("FOP")
                .courseCredit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Vineet")
                .lastName("Paleri")
                .courses(List.of(compiler,fop))
                .build();

        teacherRepository.save(teacher);

    }
}