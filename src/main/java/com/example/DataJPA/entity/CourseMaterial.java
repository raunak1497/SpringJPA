package com.example.DataJPA.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(
        exclude = "course"
)
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "courseMaterial_sequence",
            sequenceName = "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne (
            cascade = CascadeType.ALL, //this is used when we add course material and have not added course so it'll cascade it
            fetch = FetchType.LAZY //For lazy when we only want course material when we fetch it
//            fetch = FetchType.EAGER //For Eager it'll also give course when course material is fetched
    ) //Making the mapping
    @JoinColumn(  //setting up the foreign key
            name = "courseId",
            referencedColumnName = "courseId"
    )
    private Course course;
}
