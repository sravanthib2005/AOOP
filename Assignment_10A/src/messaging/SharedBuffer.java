// File: messaging/SharedBuffer.java
package messaging;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedBuffer {
    private BlockingQueue<String> buffer;

    public SharedBuffer(int capacity) {
        buffer = new LinkedBlockingQueue<>(capacity); // Thread-safe queue with fixed capacity
    }

    public void putMessage(String message) throws InterruptedException {
        buffer.put(message);  // Puts the message in the queue, waits if full
        System.out.println("Produced: " + message);
    }

    public String takeMessage() throws InterruptedException {
        String message = buffer.take();  // Takes the message from the queue, waits if empty
        System.out.println("Consumed: " + message);
        return message;
    }
}
