package com.example.testproj.json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {

    private Integer id;

    private String fullName;

    private String shortName;

    private String phoneNumber;
}
