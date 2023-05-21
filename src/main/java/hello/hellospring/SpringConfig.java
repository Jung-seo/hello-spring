package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration // 코드로 스트링 빈 등록
public class SpringConfig {

//    private final DataSource dataSource;
//    private final EntityManager em;
    private final MemberRepository memberRepository;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    @Autowired // 생성자 하나일 경우 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // Jdbc
//        return new JdbcTemplateMemberRepository(dataSource); // JdbcTemplate
//        return new JpaMemberRepository(em); // JPA
//    }

    @Bean // Spring Data JPA
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean // AOP Component 대신 빈으로 만들어도 됨
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
