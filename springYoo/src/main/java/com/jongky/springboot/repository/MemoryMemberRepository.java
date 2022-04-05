package com.jongky.springboot.repository;

import com.jongky.springboot.entity.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0l;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
