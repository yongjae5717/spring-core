package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount() {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(memberVIP, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("BASIC은 할인이 적용되지 않아야 한다.")
    void fail_discount() {
        //given
        Member memberBASIC = new Member(1L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(memberBASIC, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}