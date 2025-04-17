package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// 인터페이스 만으로도 쿼리 실행
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
