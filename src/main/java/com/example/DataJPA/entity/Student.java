package com.example.DataJPA.entity;

import lombok.*;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Data
@AllArgsConstructor //@AllArgsConstructor generates a constructor with 1 parameter for each field in your class
@NoArgsConstructor //To generate private no-args constructor
@Builder  //@Builder lets you automatically produce the code required to have your class be instantiable with
@Table(name = "tbl_student",
  uniqueConstraints = @UniqueConstraint(
     name = "emailId_uni",
     columnNames = "email_address"
 ))
public class Student {

    @Id  //@Id annotation specifies the primary key of an entity
    @SequenceGenerator( //
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(  //@GeneratedValue provides for the specification of generation strategies for the values of primary keys.
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
     private long studentId;
     private String firstName;
     private String lastName;

     @Column( //The Column annotation is used to specify the mapped column for a persistent property or field.
             name = "email_address",
             nullable = false
     )
     private String emailId;

     @Embedded //@Embedded annotation is used to specify the Address entity should be stored in the STUDENT table as a component.
     private Guardian guardian;
}
