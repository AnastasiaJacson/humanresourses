package com.vynnychuk.humanresorces.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHire;
    private int salary;
    private String department;
    private String position;
    private Boolean sex;
    private Boolean ismarried;
}
