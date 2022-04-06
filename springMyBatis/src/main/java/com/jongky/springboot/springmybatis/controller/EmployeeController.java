package com.jongky.springboot.springmybatis.controller;

import com.jongky.springboot.springmybatis.entity.Employee;
import com.jongky.springboot.springmybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeController(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("")
    public List<Employee> getAll() {
        return mapper.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable("id") int id) {
        return mapper.getById(id);
    }

    @PostMapping("")
    public Employee post(@RequestBody Employee employee) {
        mapper.insertEmployee(employee);
        return employee;
    }
}
