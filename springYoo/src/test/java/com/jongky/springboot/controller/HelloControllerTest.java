package com.jongky.springboot.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloGet() throws Exception {

        mvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
    public void helloPost() throws Exception {
        String name = "유경종";

        mvc.perform(post("/hello")
                        .param("name",name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)));
    }

}