package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        // 생성자 안에서 객체 초기화를 함께하는 것은 대부분 유지보수 관점에서 좋지 않다.
        System.out.println("생성자 호출, url = " +url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " +url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " / message: " +message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : "+url);
    }

    // 최신 스프링에서 가장 권장하는 방법 , 외부라이브러리는 사용 못하므로 Bean 기능 사용 해야한다.
    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        disconnect();
    }
}
