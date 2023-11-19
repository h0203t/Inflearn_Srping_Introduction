package Inflearn_Srping_Introduction.repository;

import Inflearn_Srping_Introduction.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member sava(Member member) {
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
        return new ArrayList<>(store.values());
    }
}
