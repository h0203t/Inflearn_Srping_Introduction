package Inflearn_Srping_Introduction.service;

import Inflearn_Srping_Introduction.repository.JdbcMemberRepository;
import Inflearn_Srping_Introduction.repository.MemberRepository;
import Inflearn_Srping_Introduction.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    //  return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
