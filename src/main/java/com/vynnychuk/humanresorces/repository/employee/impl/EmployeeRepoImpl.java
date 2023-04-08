package com.vynnychuk.humanresorces.repository.employee.impl;

import java.util.List;
import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import com.vynnychuk.humanresorces.dto.employee.BaseEmployeeDto;
import com.vynnychuk.humanresorces.entity.EmployeeEntity;
import com.vynnychuk.humanresorces.exeption.NotFoundExeption;
import com.vynnychuk.humanresorces.repository.employee.EmployeeRepo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Repository
@AllArgsConstructor
public class EmployeeRepoImpl implements EmployeeRepo{

    public static final String INSERT_EMPLOYEE_QUERY = """
            INSERT INTO EMPLOYEES (
                firstName,
                lastName,
                middleName,
                dateOfBirth,
                dateOfHire,
                salary,
                department,
                position,
                sex,
                ismarried
            ) VALUES (
                :firstName,
                :lastName,
                :middleName,
                :dateOfBirth,
                :dateOfHire,
                :salary,
                :department,
                :position,
                :sex,
                :ismarried
            )
            """;

    private static final String SELECT_EMPLOYEE_QUERY = """
                SELECT
                id,
                firstName,
                lastName,
                middleName,
                dateOfBirth,
                dateOfHire,
                salary,
                department,
                position,
                sex,
                ismarried
                FROM employees
                """;
    
    private static final String SELECT_EMPLOYEE_BY_ID_QUERY = """
                SELECT
                id,
                firstName,
                lastName,
                middleName,
                dateOfBirth,
                dateOfHire,
                salary,
                department,
                position,
                sex,
                ismarried
                FROM employees
                WHERE id = :id
                """;
    
    private static final String UPDATE_EMPLOYEE_BY_ID_QUERY = """
                UPDATE employees SET
                firstName = :firstName,
                lastName = :lastName,
                middleName = :middleName,
                dateOfBirth = :dateOfBirth,
                dateOfHire = :dateOfHire,
                salary = :salary,
                department = :department,
                position = :position,
                sex = :sex,
                ismarried = :ismarried
                WHERE id = :id
                """;
    

private static final String DELETE_EMPLOYEE_BY_ID_QUERY = """
                DELETE FROM employees WHERE id = :id
                    """;
        
    private final NamedParameterJdbcTemplate jdbcTemplate;
    
    private static final RowMapper<EmployeeEntity> EMPLOYEE_ROW_MAPPER = (rs, rowNum) -> {
        EmployeeEntity entity = new EmployeeEntity();

        entity.setId(rs.getObject("id", Long.class));
        entity.setFirstName(rs.getString("firstName"));
        entity.setLastName(rs.getString("lastName"));
        entity.setMiddleName(rs.getString("middleName"));
        entity.setDateOfBirth(rs.getObject("dateOfBirth", LocalDate.class));
        entity.setDateOfHire(rs.getObject("dateOfHire", LocalDate.class));
        entity.setSalary(rs.getObject("salary", Integer.class));
        entity.setDepartment(rs.getString("department"));
        entity.setPosition(rs.getString("position"));
        entity.setSex(rs.getObject("sex", Boolean.class));
        entity.setIsmarried(rs.getObject("ismarried", Boolean.class));

        return entity;
    };


    @Override
    public EmployeeEntity create (EmployeeEntity employee){
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
        .addValue("firstName", employee.getFirstName())
        .addValue("lastName", employee.getLastName())
        .addValue("middleName", employee.getMiddleName())
        .addValue("dateOfBirth", employee.getDateOfBirth())
        .addValue("dateOfHire", employee.getDateOfHire())
        .addValue("salary", employee.getSalary())
        .addValue("department", employee.getDepartment())
        .addValue("position", employee.getPosition())
        .addValue("sex", employee.getSex())
        .addValue("ismarried", employee.getIsmarried());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT_EMPLOYEE_QUERY, sqlParameters, keyHolder);

        Long id =(Long) keyHolder.getKeys().get("id");
        employee.setId(id);

        return employee;
        
        
    }

    @Override
    public List<EmployeeEntity> findAll(){
        return jdbcTemplate.query(SELECT_EMPLOYEE_QUERY, EMPLOYEE_ROW_MAPPER);
    }

    @Override
    public EmployeeEntity find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID_QUERY, new MapSqlParameterSource("id", id), EMPLOYEE_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExeption("Faculty with id " + id + " not found!");
        }
    }

    @Override
    public void update(EmployeeEntity employee) {
        int affectedRows = jdbcTemplate.update(UPDATE_EMPLOYEE_BY_ID_QUERY, new MapSqlParameterSource()
        .addValue("id", employee.getId())
        .addValue("firstName", employee.getFirstName())
        .addValue("lastName", employee.getLastName())
        .addValue("middleName", employee.getMiddleName())
        .addValue("dateOfBirth", employee.getDateOfBirth())
        .addValue("dateOfHire", employee.getDateOfHire())
        .addValue("salary", employee.getSalary())
        .addValue("department", employee.getDepartment())
        .addValue("position", employee.getPosition())
        .addValue("sex", employee.getSex())
        .addValue("ismarried", employee.getIsmarried()));

        if (affectedRows == 0) {
            throw new NotFoundException("Employee with id " + employee.getId() + " not found!");
        }
    }

    @Override
    public void delete(Long id) {
        int affectedRows = jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID_QUERY, new MapSqlParameterSource("id", id));

        if (affectedRows == 0) {
            throw new NotFoundException("Employee with id " + id + " not found!");
        }
    }

    // @Override
    // public List<EmployeeEntity> findAll(FacultyFitterOptions fitterOptions, Integer limit, Integer offset) {
    //     StringBuilder queryBuilder = new StringBuilder(SELECT_EMPLOYYE_QUERY);
    //     MapSqlParameterSource parameters = new MapSqlParameterSource();

    //     appendConditions(queryBuilder, parameters, fitterOptions);

    //     if (limit != null) {
    //         queryBuilder.append(" LIMIT :limit");
    //         parameters.addValue("limit", limit);
    //     }

    //     if (offset != null && offset != 0) {
    //         queryBuilder.append(" OFFSET :offset");
    //         parameters.addValue("offset", offset);
    //     }

    //     String query = queryBuilder.toString();

    //     return jdbcTemplate.query(query, parameters, EMPLOYEE_ROW_MAPPER);
    // }
}
