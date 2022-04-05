package com.jongky.springboot.repository;

import com.jongky.springboot.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class MemberRepositoryTest {

    private MemberRepository repository;

    @Autowired
    public MemberRepositoryTest(MemberRepository repository) {
        this.repository = repository;
    }


    @Test
    @Commit
    public void save() {
        String name = "ykj";

        Member member = new Member();
        member.setName(name);

        Member result = repository.save(member);

        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("jej");
        Member member2 = new Member();
        member2.setName("kjw");

        repository.save(member1);
        repository.save(member2);

        Member result1 = repository.findById(member1.getId()).get();
        Member result2 = repository.findById(member2.getId()).get();

        assertThat(result1.getId()).isEqualTo(member1.getId());
        assertThat(result2.getId()).isEqualTo(member2.getId());
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("jej");
        Member member2 = new Member();
        member2.setName("kjw");

        repository.save(member1);
        repository.save(member2);

        Member result1 = repository.findByName(member1.getName()).get();
        Member result2 = repository.findByName(member2.getName()).get();

        assertThat(result1.getId()).isEqualTo(member1.getId());
        assertThat(result2.getId()).isEqualTo(member2.getId());
    }
}