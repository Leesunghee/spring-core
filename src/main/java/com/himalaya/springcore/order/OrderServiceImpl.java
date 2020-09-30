package com.himalaya.springcore.order;

import com.himalaya.springcore.discount.DiscountPolicy;
import com.himalaya.springcore.discount.FixDiscountPolicy;
import com.himalaya.springcore.member.Member;
import com.himalaya.springcore.member.MemberRepository;
import com.himalaya.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
