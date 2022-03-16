package com.ykj.springbusiness.repository;

import com.ykj.springbusiness.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("YKJ");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println(result == member);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("YKJ");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("JEJ");
        repository.save(member2);

        Optional<Member> result = repository.findById(1l);
        assertThat(member1).isEqualTo(result.get());
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("YKJ");
        repository.save(member1);

        System.out.println(repository.findByName("YKJ").get().getName());
    }
}
