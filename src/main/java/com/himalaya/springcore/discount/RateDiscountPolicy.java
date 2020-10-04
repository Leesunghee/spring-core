package com.himalaya.springcore.discount;

import com.himalaya.springcore.annotation.MainDiscountPolicy;
import com.himalaya.springcore.member.Grade;
import com.himalaya.springcore.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
