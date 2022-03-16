package com.ykj.springbusiness.sevice;

import com.ykj.springbusiness.entity.Member;
import com.ykj.springbusiness.repository.MemberRepository;
import com.ykj.springbusiness.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("YKJ");

        //when
        Member savedMember = service.join(member);

        //then
        Assertions.assertThat(member.getName()).isEqualTo(service.findMember(savedMember.getId()).get().getName());
        System.out.println("1");


    }
    @Test
    void 중복회원_회원가입() {
        //given
        Member member = new Member();
        member.setName("YKJ");

        Member member1 = new Member();
        member1.setName("YKJ");
        //when
        service.join(member);
//        service.join(member1);

        System.out.println(service.findMembers().size());
        //then
    }

    @Test
    void findMembers() {
        //given
        //when
        //then
    }

    @Test
    void findMember() {
        //given
        //when
        //then
    }
}