package Inflearn_Srping_Introduction.repository;

import Inflearn_Srping_Introduction.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member sava(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    void clearStore();


}
