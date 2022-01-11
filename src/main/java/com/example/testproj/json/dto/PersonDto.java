package com.example.testproj.json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto {

    private Integer id;

    private String lastname;

    private String firstname;

    private String middleName;

    private Date birthDate;

    private DepartmentDto department;
}
