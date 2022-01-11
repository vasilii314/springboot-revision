package com.example.testproj.json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filter {

    private String lastname;

    private String date;

    private String department;
}
