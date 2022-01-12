package com.example.testproj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "new_person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewPerson {

    @Id
    @Column(name = "new_person_id")
    private Integer id;

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

    @NotNull
    @Column(name = "creation_date")
    private Date creationDate;

    @NotNull
    @Column(name = "creation_time")
    private Time creationTime;
}
