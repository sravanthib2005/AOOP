// File: messaging/Producer.java
package messaging;

public class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String message = "Message " + i;
            try {
                buffer.putMessage(message);
                Thread.sleep(500);  // Simulating time taken to produce the message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
