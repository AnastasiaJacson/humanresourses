package com.vynnychuk.humanresorces.dto.employee;

import java.util.Date;

import lombok.Data;

@Data
public class BaseEmployeeDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private Date dateOfHire;
    private int salary;
    private String department;
    private String position;
    private Boolean sex;
    private Boolean ismarried;
      
}
