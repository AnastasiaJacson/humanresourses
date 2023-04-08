package com.vynnychuk.humanresorces.service.employee;

import java.util.List;

import com.vynnychuk.humanresorces.dto.EmployeeDto;
import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;

public interface EmployeeServices {

    EmployeeDto create(BaseEmployeeDto employee);
    public List<EmployeeDto> findAll();
    public EmployeeDto find(Long id);
    void update(Long id, BaseEmployeeDto employeeDto);
    void delete(Long id);
    //ValueDto<Integer> count(FacultyFitterOptions params);
}
