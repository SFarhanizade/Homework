public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
