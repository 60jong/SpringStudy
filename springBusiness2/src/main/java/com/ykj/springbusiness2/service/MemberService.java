package com.ykj.springbusiness2.service;

import com.ykj.springbusiness2.entity.Member;
import com.ykj.springbusiness2.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository repository;

    public MemberService() {

    }

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member join(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m ->
                {throw new IllegalArgumentException("이미 존재하는 회원입니다.");});
        return repository.save(member);
    }
    public Optional<Member> findMember(Long id){
        return repository.findById(id);
    }
    public List<Member> findMembers(){
        return repository.findAll();
    }

}
