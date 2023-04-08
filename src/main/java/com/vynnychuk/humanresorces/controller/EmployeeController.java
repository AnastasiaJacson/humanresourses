package com.vynnychuk.humanresorces.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.vynnychuk.humanresorces.dto.EmployeeDto;
import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;
import com.vynnychuk.humanresorces.service.employee.EmployeeServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping("employees")

public class EmployeeController {

    
    private final EmployeeServices employeeServices;

    // public EmployeeController(EmployeeServices employeeServices) {
    //     this.employeeServices = employeeServices;
    // }

    //@RequestMapping(method = RequestMethod.POST, value = "create")
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody BaseEmployeeDto employee){
        return employeeServices.create(employee);
    }

    @GetMapping
    public List<EmployeeDto> findAll(){
        return employeeServices.findAll();
    }

    // @GetMapping
    // public List<EmployeeDto> findAll(EmployeeFitterOptions fitterOptions, Integer limit, Integer offset) {
    //     return employeeServices.findAll(fitterOptions, limit, offset);
    // }

    @GetMapping("{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public EmployeeDto find(@PathVariable Long id) {
        return employeeServices.find(id);
    }

    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody BaseEmployeeDto employee) {
        employeeServices.update(id, employee);
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeeServices.delete(id);
    }

    

}
