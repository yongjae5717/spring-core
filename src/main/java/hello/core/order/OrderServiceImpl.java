package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {



    /**
     * 역할과 구현을 충실히했다.
     * 다형성 활용하고 인터페이스와 구현 객체를 분리했다.
     * 준수하지 않은점: OCP, DIP
     * DIP: 클레스 의존관계는 인터페이스뿐아니라 구현 클레스에도 의존하고 있다.
     * (인터페이스: DiscountPolicy) (구현 클레스: FixDiscountPolicy, RateDiscountPolicy)
     * OCP: 주석을 달았지만 구현체에 변경이 있었기에 위반이다.
     */
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     * OCP, DIP 해결방법
     * Impl에 DiscountPolicy 구현객체를 대신 주입을 해주면된다!
     * private DiscountPolicy discountPolicy; 인터페이스를 의존하면된다. (하지만 이는 null을 일으킴으로 오류가 발생한다.)
     * 따라서 AppConfig를 생성하여 기획자와 같은 임무를 수행하도록 해준다.
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 조회
        Member member = memberRepository.findById(memberId);
        //할인 정책 가격 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
