package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 제외할 것 필터로 설정 (@Configuration 클래스 제외 AppConfig)
@ComponentScan (
        // 시작 패키지 설정  {"", ""} 여러개 지정 가능 , default: @ComponentScan을 붙인 패키지가 시작.
        // 즉 설정 정보 클래스를 최상단에 두는 것을 권장한다.
//        basePackages = "hello.core",
//        basePackageClasses =  AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

  /*  @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
