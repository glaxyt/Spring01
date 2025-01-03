package hello.hello_spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hello_spring.aop.TImeTraceAop;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JdbcTemplateMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	// @Bean
	// public TImeTraceAop tImeTraceAop() {
	// 	return new TImeTraceAop();
	// }

	// @Bean
	// public MemberRepository memberRepository() {
	// 	// return new MemoryMemberRepository();
	// 	// return new JdbcMemberRepository(dataSource);
	// 	// return new JdbcTemplateMemberRepository(dataSource);
	// 	// return new JpaMemberRepository(em);
	//
	// }
}
