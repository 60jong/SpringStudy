package com.jongky.springboot.service;

import com.jongky.springboot.entity.Member;
import com.jongky.springboot.repository.MemberRepository;
import com.jongky.springboot.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class MemberServiceTest {

    private MemberService service;
    private MemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }


    @Test
    public void 회원가입() {

        Member member1 = new Member();
        member1.setName("ykj");

        service.join(member1);

//        Member member2 = new Member();
//        member2.setName("ykj");
//
//        service.join(member2);

        Member member3 = new Member();
        member3.setName("jej");

        service.join(member3);


    }

}