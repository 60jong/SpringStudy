package com.ykj.springbusiness.sevice;

import com.ykj.springbusiness.entity.Member;
import com.ykj.springbusiness.repository.MemberRepository;
import com.ykj.springbusiness.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService service;
    @Autowired
    MemoryMemberRepository repository;

    @Test
    void 회원가입() throws SQLException {
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
    void 중복회원_회원가입() throws SQLException {
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