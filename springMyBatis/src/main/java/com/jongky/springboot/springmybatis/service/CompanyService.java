package com.jongky.springboot.springmybatis.service;

import com.jongky.springboot.springmybatis.entity.Company;
import com.jongky.springboot.springmybatis.entity.Employee;
import com.jongky.springboot.springmybatis.mapper.CompanyMapper;
import com.jongky.springboot.springmybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }


    public List<Employee> getEmployeeList(int companyId) {
        return employeeMapper.getByCompanyId(companyId);
    }

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();

        for(Company company : companyList) {
            company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
        }

        return companyList;
    }
}
