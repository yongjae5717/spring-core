package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository(), new discountPolicy()
    // MemoryMemberRepository 2번 호출 ? 싱글톤이 파괴?? 자바코드니깐 ?? 테스트르 한번해보자


    /**
     * @Bean을 통하여 스프링 컨테이너에 등록한다.
     */

    /**
     * 의존관계 주입: DI
     * memberServiceImpl입장에서 보면 의존관계를 외부(AppConfig)가 주입해주는 것 같다.
     */
    @Bean
    public MemberService memberService(){
        // 생성자 주입
        return new MemberServiceImpl(MemberRepository());
    }

    //표현식 (MemoryMemberRepository)
    @Bean
    @Primary
    public MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        // 생성자 주입
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    //표현식(FixDiscountPolicy or RateDiscountPolicy)
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}