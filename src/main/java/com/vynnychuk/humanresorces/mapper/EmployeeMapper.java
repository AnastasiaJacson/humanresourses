package com.vynnychuk.humanresorces.mapper;

import org.mapstruct.Mapper;

import com.vynnychuk.humanresorces.dto.EmployeeDto;
import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;
import com.vynnychuk.humanresorces.entity.EmployeeEntity;
import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    
    EmployeeEntity toEntity(BaseEmployeeDto employeeDto);

    EmployeeDto toDto(EmployeeEntity employeeEntity);
    List<EmployeeDto> toDtoList(List<EmployeeEntity> employeeEntities);

    

}
