package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Lombok : getter, setter 자동 생성
@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;
    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(123);

        int age = helloLombok.getAge();
        System.out.println("age = " + age);

        System.out.println(helloLombok);
    }
}
