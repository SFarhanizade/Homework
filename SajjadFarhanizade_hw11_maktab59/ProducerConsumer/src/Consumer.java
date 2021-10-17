public class Consumer implements Runnable {
    SharedObject sharedObject;

    public Consumer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            try {
                sharedObject.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
