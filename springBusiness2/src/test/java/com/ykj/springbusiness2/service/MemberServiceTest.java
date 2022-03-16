package com.ykj.springbusiness2.service;

import com.ykj.springbusiness2.entity.Member;
import com.ykj.springbusiness2.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemoryMemberRepository repository = new MemoryMemberRepository();
    private MemberService service = new MemberService(repository);
//    @BeforeEach
//    public void beforeEach() {
//        repository.clearStore();
//    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("YKJ");
        service.join(member);
    }

    @Test
    void findMember() {
        Member member = new Member();
        member.setName("YKJ");
        service.join(member);
    }

    @Test
    void findMembers() {
        Member member = new Member();
        member.setName("YKJ");
        service.join(member);

        System.out.println(service.findMembers().size());
    }
}