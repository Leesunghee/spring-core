package com.himalaya.springcore;

import com.himalaya.springcore.discount.DiscountPolicy;
import com.himalaya.springcore.discount.RateDiscountPolicy;
import com.himalaya.springcore.member.MemberRepository;
import com.himalaya.springcore.member.MemberService;
import com.himalaya.springcore.member.MemberServiceImpl;
import com.himalaya.springcore.member.MemoryMemberRepository;
import com.himalaya.springcore.order.OrderService;
import com.himalaya.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
