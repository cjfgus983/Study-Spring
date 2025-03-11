package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {


    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트 하나하나 끝날 때 마다 작동하는 코드
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("test");
        repository.save(member);


        // 일일히 출력하는게 아니라 이런식으로 확인 가능
        // 만약 다르다면 체크 표시 안 뜸
        Member result = repository.findById(member.getId()).get();

        // Assertions.assertEquals(result, member);

        Assertions.assertThat(member).isEqualTo(result);

        // 위 두가지 방법으로 체크 가능
        // 요즘에는 아래 방법으로 자주 쓴다고 함
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        Member result = repository.findByName("test1").get();

        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}

// 테스트 하나가 끝나면 데이터를 삭제해줘야함