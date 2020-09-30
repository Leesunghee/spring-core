package com.himalaya.springcore.order;

import com.himalaya.springcore.member.Grade;
import com.himalaya.springcore.member.Member;
import com.himalaya.springcore.member.MemberService;
import com.himalaya.springcore.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calcluatePrice = " + order.calCulatePrice());

    }
}
