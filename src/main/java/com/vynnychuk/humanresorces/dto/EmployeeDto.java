package com.vynnychuk.humanresorces.dto;

import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;

import lombok.Data;

@Data
public class EmployeeDto extends BaseEmployeeDto{
    private Long id;
}
