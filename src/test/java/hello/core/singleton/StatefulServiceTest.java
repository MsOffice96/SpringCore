package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        // ThreadA: A사용자가 10000원을 주문
//        statefulService1.order("userA", 10000);
//        // ThreadB: B사용자가 20000원을 주문
//        statefulService2.order("userB", 20000);

        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);
        org.assertj.core.api.Assertions.assertThat(userAPrice).isEqualTo(10000);
        org.assertj.core.api.Assertions.assertThat(userBPrice).isEqualTo(20000);
//        // ThreaA: A사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}