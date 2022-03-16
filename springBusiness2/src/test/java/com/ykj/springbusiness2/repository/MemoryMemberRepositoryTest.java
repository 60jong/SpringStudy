package com.ykj.springbusiness2.repository;

import com.ykj.springbusiness2.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    public void findById() {
        Member member = new Member();
        member.setName("YKJ");
        repository.save(member);
        System.out.println(repository.findById(1l));
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("YKJ");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("JEJ");
        repository.save(member1);

        Member result = repository.findByName("YKJ").get();

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findAll() {
    }
}