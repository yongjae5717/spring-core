package hello.core.member;

import java.util.HashMap;
import java.util.Map;


//db를 연결하지 않고 메모리를 사용하는 것
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
