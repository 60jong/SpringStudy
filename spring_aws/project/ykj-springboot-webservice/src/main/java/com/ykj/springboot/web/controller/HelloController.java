package com.ykj.springboot.web.controller;

import com.ykj.springboot.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam(name = "name",defaultValue = "name") String name, @RequestParam(name = "age", defaultValue = "0") int age) {
        return new HelloResponseDto(name, age);
    }
}
