package hello.core.singleton;

public class SingletonService {

    // 한번만 띄우도록 자기 자신을 내부의 private static 으로 선언
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    // 외부에서 new 키워드로 생성자를 만들지 못하도록 private로 막아버린다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
