package com.example.DataJPA.repository;

import com.example.DataJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String character);

    List<Student> findByLastName(String lastName);

    List<Student>  findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String FirstName,String lastName);

    //JPQL queries are based on classes we have created not based on the database
    @Query("Select s from Student s where s.emailId = ?1") //@Query annotation declares finder queries directly on repository methods.
    Student getStudentByEmail(String emailId);

    //JPQL queries are based on classes we have created not based on the database
    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmail(String emailId);

    //Native query
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailNative(String emailId);

    //Native query
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId ",
            nativeQuery = true
    )
    Student getStudentByEmailNativeNamedParam(
            @Param("emailId") String emailId
    );

    //Update query
    @Modifying //Used when using modifying queries
    @Transactional //used when trying to declare a transaction
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2 ",
            nativeQuery = true
    )
    int updateStudentNameByEmail(String firstName,String emailid);
}
