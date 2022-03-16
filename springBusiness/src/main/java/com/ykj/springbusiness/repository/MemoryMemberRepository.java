package com.ykj.springbusiness.repository;

import com.ykj.springbusiness.entity.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 0l;
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
        Optional<Member> optional = store.values().stream()
                .filter(v -> v.getName().equals(name))
                .findAny();
        return optional;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
