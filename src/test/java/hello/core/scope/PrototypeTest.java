package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println(" find prototype bean1 ");
        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean1 = " + protoTypeBean1);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);
        Assertions.assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);

        // 직업 호출
        protoTypeBean1.destroy();

        ac.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean{
        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init(singleton)");
        }
        @PreDestroy
        void destroy() {
            System.out.println("ProtoTypeBean.destroy(destroy)");
        }
    }
}
