package com.jongky.springboot.springmybatis.controller;

import com.jongky.springboot.springmybatis.entity.Company;
import com.jongky.springboot.springmybatis.mapper.CompanyMapper;

import com.jongky.springboot.springmybatis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyMapper mapper;
    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyMapper mapper, CompanyService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("")
    public Company post(@RequestBody Company company) {
        mapper.insert(company);

        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable("id") int id) {
        return mapper.getById(id);
    }

}
