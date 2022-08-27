package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    /**
     * 순수한 DI컨테이너는 AppConfig를 요청할 때마다 객체를 새로 생성한다.
     * 고객 트래픽이 초당 100이 나오면 초당 100개 객체가 생성된다. -> 메모리 낭비가 심하다!
     * 해결방안: 초기 1개 생성 후 공유하는 설계 -> 싱글톤 패턴!
     */
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    public void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //2. 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //3. 1과 2는 다른 객체이어야한다.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
