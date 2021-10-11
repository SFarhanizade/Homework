import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        aList.add(new A());
        List<B> bList = new ArrayList<>();
        bList.add(new B());
        print(aList);
        print(bList);
        print2(aList);
        //print2(bList);

    }

    static void print(List<? extends A> list){
        A a = list.get(0);
        System.out.println(a);
        //No add available
        //list.add(new A());
    }
    static void print2(List<? super A> list){
        Object o = list.get(0);
        System.out.println(o);
        //add available
        list.add(new B());
    }
}

class A{

}
class B extends A{

}
