# ApplicationContext : 스프링 컨테이너 , 인터페이스이며 Bean에 등록된 모든 메소드를 호출한다. 
ex ) 
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만든 것. 

BeanFactory
스프링 컨테이너의 최상위 인터페이스 
스프링 빈을 관리하고 조회하는 역할을 담당 

ApplicationContext -> 주로 이 인터페이스를 사용한다. 
BeanFactory의 기능(빈 관리)을 상속받아 제공 + 추가 어플리케이션 관리 기능 
-> 추가 다른기능 
ㅁ 메시지소스 : 나라별 언어별로 출력
ㅁ 환경변수 : 로컬(pc), 개발(테스트 서버), 운영(실제 프로덕션) 구분 처리 
ㅁ 애플리케이션 이벤트 : 이벤트 발행 및 구독하는 모델 관리
ㅁ 리소스조회 : 파일 , 클래스패스, 외부 등 리소스 편리하게 조회  

스프링 컨테이너는 다양한 형식의 정보를 받아드릴 수 있도록 유연하게 설계되어 있다. 
자바, XML , Groovy 등 

BeanDefinition : 컨테이너가 이정보로 가지고 동작하며 동작 언어가 뭔지 모른채로 실행만한다.
