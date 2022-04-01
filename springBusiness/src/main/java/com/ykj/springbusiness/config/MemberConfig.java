package com.ykj.springbusiness.config;

import com.ykj.springbusiness.entity.Member;
import com.ykj.springbusiness.repository.JPAMemberRepository;
import com.ykj.springbusiness.repository.MemberRepository;
import com.ykj.springbusiness.repository.MemoryMemberRepository;
import com.ykj.springbusiness.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class MemberConfig {

    EntityManager em;

    @Autowired
    public MemberConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JPAMemberRepository(em);
    }

}
