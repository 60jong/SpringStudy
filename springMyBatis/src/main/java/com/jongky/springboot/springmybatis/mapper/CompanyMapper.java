package com.jongky.springboot.springmybatis.mapper;

import com.jongky.springboot.springmybatis.entity.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyMapper {

    @Select("select * from company where id = #{id}")
    @Results(id = "CompanyMap", value = {
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
    })
    Optional<Company> getById(@Param("id") int id);

    @Select("select * from company")
    @ResultMap("CompanyMap")
    List<Company> getAll();

    @Insert("insert into company(company_name,company_address) values(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);

    @Delete("delete from company where id=#{id}")
    int delete(@Param("id") int id);
}
