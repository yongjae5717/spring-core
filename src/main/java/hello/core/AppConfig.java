package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    /**
     * 의존관계 주입: DI
     * memberServiceImpl입장에서 보면 의존관계를 외부(AppConfig)가 주입해주는 것 같다.
     */
    public MemberService memberService(){
        // 생성자 주입
        return new MemberServiceImpl(MemberRepository());
    }

    //표현식 (MemoryMemberRepository)
    private static MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){
        // 생성자 주입
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    //표현식(FixDiscountPolicy or RateDiscountPolicy)
    public static DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}