package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // final 객체 자체를 다른 객체로 변경할 수 없으나 객체 필드는 변경할 수 있다 .
    // final은 무조건 기본 할당이 되거나 생성자를 통해 할당이 되어야 한다.

    private final MemberRepository memberRepository;

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
