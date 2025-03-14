//package hello.hello_spring;
///*
//*
//*  자바 코드로 직접 스프링 빈에 컴포넌트들 등록하기
//*
//* */
//
//import hello.hello_spring.repository.MemberRepository;
//import hello.hello_spring.repository.MemoryMemberRepository;
//import hello.hello_spring.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
///*
//*
//* 멤버 리포지토리를 생성해서 멤버 서비스에 넣어줌
//*
//* */
//@Configuration
//public class SpringConfig {
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
