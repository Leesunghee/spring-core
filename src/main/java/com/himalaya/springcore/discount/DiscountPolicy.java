package com.himalaya.springcore.discount;

import com.himalaya.springcore.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
