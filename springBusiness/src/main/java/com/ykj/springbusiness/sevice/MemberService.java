package com.ykj.springbusiness.sevice;

import com.ykj.springbusiness.entity.Member;
import com.ykj.springbusiness.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private MemoryMemberRepository repository = new MemoryMemberRepository();

    public MemberService(MemoryMemberRepository repository) {
        this.repository = repository;
    }

    public Member join(Member member) {
        if (repository.findByName(member.getName()).isEmpty()) {
            return repository.save(member);
        }
        else{
            throw new IllegalArgumentException("이미 존재하는 회원");
        }
        //validateDuplicateMember(member);
        //return repository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName()).ifPresent(
                m -> {
                    throw new IllegalArgumentException("이미 존재하는 화원입니다.");
                });
    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findMember(Long id){
        return repository.findById(id);
    }
}
