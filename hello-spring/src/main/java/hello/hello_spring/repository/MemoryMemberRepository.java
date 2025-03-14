package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이 될 가능성이 있으면 Optional.ofNullable로
        // 감싸기
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name))
                .findAny();
    }
    // store 에 키, 벨류로 저장되어있는데 그 벨류들만 들고와서 쭉 펼친 다음 필터링을 한다.
    // 멤버 하나하나를 뒤지며 이름 받아오고 그게 인자로 받은 name 과 같은것을 하나 찾으면 리턴

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();

    }

}
