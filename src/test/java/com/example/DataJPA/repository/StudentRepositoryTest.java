package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Guardian;
import com.example.DataJPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("raunak1497@gmail.com")
                .firstName("Raunak")
                .lastName("Singh")
//                .guardianName("Basant")
//                .guardianEmail("basant@gmail.com")
//                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Basant")
                .email("basant@gmail.com")
                .mobile("1234567890")
                .build();

        Student student = Student.builder()
                .emailId("georgain4165@gmail.com")
                .firstName("Ronny")
                .lastName("Singh")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Raunak");

        System.out.println("Students : " + students);
    }

    @Test
    public void findByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("o");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByLastName(){
        List<Student> students =
                studentRepository.findByLastName("Singh");

        System.out.println("Students : " + students);
    }

    @Test
    public  void printStudentByGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Basant");

        System.out.println("Students : " + students);
    }

    @Test
    public  void printStudentByFullName(){
        Student students =
                studentRepository.findByFirstNameAndLastName("Raunak","Singh");

        System.out.println("Students : " + students);
    }

    @Test
    public  void printStudentByEmail(){
        Student students =
                studentRepository
                        .getStudentByEmail("georgian4165@gmail.com");

        System.out.println("Students : " + students);
    }

    @Test
    public  void printStudentFirstNameByEmail(){
        String students =
                studentRepository
                        .getStudentFirstNameByEmail("georgain4165@gmail.com");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByEmailNative(){
        Student students =
                studentRepository
                        .getStudentByEmailNative("georgain4165@gmail.com");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByEmailNativeParam(){
        Student students =
                studentRepository
                        .getStudentByEmailNativeNamedParam("georgain4165@gmail.com");

        System.out.println("Students : " + students);
    }

    @Test
    public void updateStudentByEmailId(){
        studentRepository.updateStudentNameByEmail(
                "Raunak",
                "georgain4165@gmail.com");
    }
}