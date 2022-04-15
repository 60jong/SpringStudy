package com.jongky.springboot.springmybatis.controller;

import com.jongky.springboot.springmybatis.entity.Company;
import com.jongky.springboot.springmybatis.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyController(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable("id") int id) {
        return companyMapper.getById(id).get();
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
    }

    @PostMapping("")
    public Company postCompany(@RequestBody Company company) {
        companyMapper.insert(company);

        return company;
    }
//
//    @PutMapping("")
//
    @DeleteMapping("/{id}")
    public String deleteCompany(int id) {
        companyMapper.delete(id);

        return "Delete Success";
    }

}
