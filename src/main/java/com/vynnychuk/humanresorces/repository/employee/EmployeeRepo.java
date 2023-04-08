package com.vynnychuk.humanresorces.repository.employee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vynnychuk.humanresorces.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo {
    EmployeeEntity create (EmployeeEntity employee);
    //List<EmployeeEntity> findAll(EmployeeFitterOptions fitterOptions, Integer limit, Integer offset);

    List<EmployeeEntity> findAll();
    EmployeeEntity find(Long id);
    void update(EmployeeEntity employee);
    void delete(Long id);
}
