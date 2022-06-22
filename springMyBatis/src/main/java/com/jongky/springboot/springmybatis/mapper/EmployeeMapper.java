package com.jongky.springboot.springmybatis.mapper;

import com.jongky.springboot.springmybatis.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    @Insert("insert into employee(company_id,employee_name,employee_address) values(#{employee.companyId},#{employee.name},#{employee.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEmployee(@Param("employee") Employee employee);

    @Select("select * from employee")
    @Results(id = "EmployeeMap", value = {
            @Result(property = "companyId", column = "company_id"),
            @Result(property = "name", column = "employee_name"),
            @Result(property = "address", column = "employee_address")
    })
    List<Employee> getAll();

    @Select("select * from employee where id = #{id}")
    @ResultMap("EmployeeMap")
    Optional<Employee> getById(@Param("id") int id);

    @Select("select * from employee where company_id = #{companyId}")
    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);
}