package com.example.testproj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Data
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @Column(name = "short_name")
    private String shortName;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "department")
    private List<Person> people;
}
