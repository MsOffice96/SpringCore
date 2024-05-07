package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // Spring을 사용하기 전 (AppConfig 사용)
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();


        // MemberService memberService = new MemberServiceImpl();

        // Spring의 Container
        // AnnotationConfigApplication(AppConfig.class) AppConfig class의 @Bean 을 Spring Container에 객체 생성 및 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig의 "memberService" method 와 type(MemberService.class)를 명시
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
