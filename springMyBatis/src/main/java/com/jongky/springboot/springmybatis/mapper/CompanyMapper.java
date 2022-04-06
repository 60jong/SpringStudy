package com.jongky.springboot.springmybatis.mapper;

import com.jongky.springboot.springmybatis.entity.Company;
import com.jongky.springboot.springmybatis.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyMapper {

    @Insert("insert into company(company_name,company_address) values(#{company.name},#{company.address})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(@Param("company") Company company);


    @Select("select * from company")
    @Results( id="CompanyMap",value = {
        @Result(property = "name",column = "company_name"),
        @Result(property = "address", column = "company_address")
    })
    List<Company> getAll();

    @Select("select * from company where id = #{id}")
    @ResultMap("CompanyMap")
    Optional<Company> getById(@Param("id") int id);


}
