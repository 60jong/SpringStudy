package com.jongky.springboot.springmybatis.entity;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private int companyId;
    private String name;
    private String address;
}
