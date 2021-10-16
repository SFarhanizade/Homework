import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyList<Integer> myList = new MyList<>();
        int NUMBER = 100_000;
        List even = new ArrayList();
        List odd = new ArrayList();
        for (int i = 0; i < NUMBER+1; i++) {
            if(i%2==0)
                even.add(i);
            else
                odd.add(i);
        }
        Thread t1 = new Thread(new MyThread(even,myList));
        t1.start();
        Thread t2 = new Thread(new MyThread(odd,myList));
        t2.start();

        Thread.sleep(2000);
        for (Integer num : myList.getList())
            System.out.println(num);
    }
}
