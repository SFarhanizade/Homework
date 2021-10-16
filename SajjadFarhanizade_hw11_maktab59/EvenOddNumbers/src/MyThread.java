import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable{
    List items;
    MyList myList;

    public MyThread(List items, MyList myList) {
        this.items = items;
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < items.size(); i++) {
            try {
                myList.add(items.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
