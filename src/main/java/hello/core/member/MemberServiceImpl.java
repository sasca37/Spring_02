package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //final 객체 자체를 다른 객체로 변경할 수 없으나 객체 필드는 변경할 수 있다 .
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
