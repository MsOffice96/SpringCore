package hello.core.singleton;

public class StatefulService {

//    private int price;

    // // stateful function
//    public void order(String name, int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price;
//    }

    // stateless function
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price;
    }

//    public int getPrice(){
//        return this.price;
//    }
}
