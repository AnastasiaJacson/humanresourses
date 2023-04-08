package com.vynnychuk.humanresorces.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vynnychuk.humanresorces.dto.EmployeeDto;
import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;
import com.vynnychuk.humanresorces.entity.EmployeeEntity;
import com.vynnychuk.humanresorces.mapper.EmployeeMapper;
import com.vynnychuk.humanresorces.repository.employee.EmployeeRepo;
import com.vynnychuk.humanresorces.service.employee.EmployeeServices;

import lombok.AllArgsConstructor;

//@Component
@Service
@AllArgsConstructor
public class EmployeeServicesImpl implements EmployeeServices {

    private final EmployeeRepo employeeRepo;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto create(BaseEmployeeDto employeeDto){
        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDto);
        EmployeeEntity createdEmployeeEntity = employeeRepo.create(employeeEntity);
        return employeeMapper.toDto(createdEmployeeEntity);
    }
    
    @Override
    public List<EmployeeDto> findAll(){
        BaseEmployeeDto employeeDto1 = new BaseEmployeeDto();
        List<EmployeeEntity> employeeEntitys = employeeRepo.findAll(); 
        
        return employeeMapper.toDtoList(employeeEntitys);
    }
    
    @Override
    public EmployeeDto find(Long id){
        EmployeeEntity employeeEntity = employeeRepo.find(id);
        return employeeMapper.toDto(employeeEntity);

    }

    @Override
    public void update(Long id, BaseEmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDto);
        employeeEntity.setId(id);

        employeeRepo.update(employeeEntity);
    }

    @Override
    public void delete(Long id) {
        employeeRepo.delete(id);
    }
    
    // @Override
    // public List<EmployeeDto> findAll(@RequestParam(required = false) EmployeeFitterOptions fitterOptions, @RequestParam(defaultValue = "100", required = false) Integer limit, @RequestParam(defaultValue = "0", required = false) Integer offset) {
    //     List<EmployeeEntity> facultyEntities = employeeRepo.findAll(fitterOptions, limit, offset);
    //     return employeeMapper.toDtoList(employeeEntities);
    // }
}
