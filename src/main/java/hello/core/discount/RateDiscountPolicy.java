package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    //할인률 정의
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        // 10% 할인을 적용하는 알고리즘
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100 ;
        }
        else{
            return 0;
        }
    }
}
