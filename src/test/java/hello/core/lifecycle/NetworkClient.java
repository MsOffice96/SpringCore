package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.PrivateKey;

// InitializingBean : 초기화 인터페이스 : bean 생성후 Initalize
// DisposableBean : spring 종료전 bean 을 Destroy를 할때
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println(" 생성자 호출 " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct // Bean 이 생성된 이후 initalize
    public void init(){
        System.out.println("Network client init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy // Bean 이 삭제 될때 destroys
    public void close(){
        System.out.println("NetworkClient.Close");
        disconnect();
    }

//  override:  public class NetworkClient implements InitializingBean, DisposableBean
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
