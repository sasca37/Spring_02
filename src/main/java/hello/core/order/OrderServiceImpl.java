package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // OrderServiceImpl 입장에서는 어떤 구현객체가 사용될지 모름
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 할인과 관련된 정보를 discountpolicy 에 두었으므로 오더 서비스 입장에선 단일책임원칙을 잘 설계한 것이된다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 싱글톤 테스트용 (다른 빈에서 같은 객체생성시 )
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
