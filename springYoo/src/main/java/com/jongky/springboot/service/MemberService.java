package com.jongky.springboot.service;

import com.jongky.springboot.entity.Member;
import com.jongky.springboot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member join(Member member) {

        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
        repository.save(member);

        return member;
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return repository.findById(id);
    }
}
