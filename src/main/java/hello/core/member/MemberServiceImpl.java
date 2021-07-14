package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // final 객체 자체를 다른 객체로 변경할 수 없으나 객체 필드는 변경할 수 있다 .
    // final은 무조건 기본 할당이 되거나 생성자를 통해 할당이 되어야 한다.

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class) 기능이 내부적으로 포함되어있음 , 자동 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 테스트용 (다른 빈에서 같은 객체생성시 )
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
