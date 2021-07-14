package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifecycleTest() {
        // close를 별로 쓸일이 없긴 하지만 ConfigurableApplicationContext(상위, 부모가 자식 담은 상황)  사용해서 close를 사용
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        //destroyMethod 는 추론기능이 있어서 close, shutdown 같은 메서드는 추론해서 종료한다. 없애고싶으면 ""로 설정
        @Bean//(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient( ) {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
