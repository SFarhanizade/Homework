public class SharedObject {
    int value=0;
    public synchronized void produce() throws InterruptedException {
        while (value==10)
            wait();
        System.out.print(value);
        value++;
        System.out.println(" + 1 = "+value);
        notifyAll();
        Thread.sleep(300);
    }
    public synchronized void consume() throws InterruptedException {
        while(value==0)
            wait();
        System.out.print(value);
        value--;
        System.out.println(" - 1 = "+value);
        notifyAll();
        Thread.sleep(300);
    }

    public int getValue() {
        return value;
    }
}
