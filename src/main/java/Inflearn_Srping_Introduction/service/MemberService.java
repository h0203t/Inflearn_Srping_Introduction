package Inflearn_Srping_Introduction.service;

import Inflearn_Srping_Introduction.domain.Member;
import Inflearn_Srping_Introduction.repository.MemberRepository;
import Inflearn_Srping_Introduction.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원가입
    * */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        validataDuplicateMember(member); // 중복 회원 검증
        memberRepository.sava(member);
        return member.getId();
    }
    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /*
    * 회원 검색
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
