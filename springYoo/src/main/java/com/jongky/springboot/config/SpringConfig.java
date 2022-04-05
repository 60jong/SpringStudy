package com.jongky.springboot.config;

import com.jongky.springboot.repository.JpaMemberRepository;
import com.jongky.springboot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final MemberRepository repository;

    @Autowired
    public SpringConfig(MemberRepository repository) {
        this.repository = repository;
    }
}
