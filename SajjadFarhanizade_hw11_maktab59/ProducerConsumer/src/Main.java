import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        SharedObject sharedObject= new SharedObject();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            if(i<3)
                executorService.execute(new Producer(sharedObject));
            else
                executorService.execute(new Consumer(sharedObject));
        }
    }
}
