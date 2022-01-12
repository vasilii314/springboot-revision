package com.example.testproj.kafka.msg;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
public class NewPersonMsg {

    @NotNull
    private Integer id;

    @NotBlank
    @Length(max = 256)
    private String lastname;

    @NotBlank
    @Length(max = 256)
    private String firstname;

    @NotBlank
    @Length(max = 256)
    private String middleName;

    @NotNull
    private Date birthDate;

    @NotNull
    private Date creationDate;

    @NotNull
    private Time creationTime;
}
