// File: messaging/Consumer.java
package messaging;

public class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                buffer.takeMessage();
                Thread.sleep(1000);  // Simulating time taken to consume the message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
