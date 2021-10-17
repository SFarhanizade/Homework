public class Producer implements Runnable{
    SharedObject sharedObject;

    public Producer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 12; i++) {
            try {
                sharedObject.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
