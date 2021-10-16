import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyList<T> {
    private ArrayList<T> list = new ArrayList<>();
    private boolean isbusy = false;

    public void add(T item) throws InterruptedException {
            while (isbusy) {
                wait();
            }
        synchronized (this) {
            isbusy = true;
            list.add(item);
            isbusy = false;
            notifyAll();
        }
    }

    public ArrayList<T> getList() {
        return list;
    }
}
