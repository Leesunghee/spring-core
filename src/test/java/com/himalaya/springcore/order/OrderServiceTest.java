package com.himalaya.springcore.order;

import com.himalaya.springcore.AppConfig;
import com.himalaya.springcore.member.Grade;
import com.himalaya.springcore.member.Member;
import com.himalaya.springcore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long meberId = 1L;
        Member member = new Member(meberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(meberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
