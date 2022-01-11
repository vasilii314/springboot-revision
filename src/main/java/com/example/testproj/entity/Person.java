package com.example.testproj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @NotBlank
    @Column(name = "lastname")
    @Length(max = 256)
    private String lastname;

    @NotBlank
    @Column(name = "firstname")
    @Length(max = 256)
    private String firstname;

    @NotBlank
    @Column(name = "middle_name")
    @Length(max = 256)
    private String middleName;

    @NotNull
    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
