package Inflearn_Srping_Introduction.repository;

import Inflearn_Srping_Introduction.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void sava() {
        Member member = new Member();
        member.setName("Gwon");

        repository.sava(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.sava(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.sava(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);
    }
}
