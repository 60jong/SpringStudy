package com.jongky.springboot.springmybatis.controller;

import com.jongky.springboot.springmybatis.entity.Company;
import com.jongky.springboot.springmybatis.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyMapper mapper;

    @Autowired
    public CompanyController(CompanyMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("")
    public Company post(@RequestBody Company company) {
        mapper.insert(company);

        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
        return mapper.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable("id") int id) {
        return mapper.getById(id);
    }
}
