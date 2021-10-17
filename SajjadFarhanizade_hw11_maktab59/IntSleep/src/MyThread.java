public class MyThread implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
                break;
            }
        }
    }
}
