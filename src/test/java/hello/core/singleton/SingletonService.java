package hello.core.singleton;

public class SingletonService {

    // Java 시작시 SingletonService instance를 조기화해서 static 영역에 instance를 가지고 있는다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
