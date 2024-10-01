package boundedbuffer;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer {
    private final int maxCapacity = 10;
    private final Queue<Integer> buffer = new LinkedList<>();
    
    // Synchronization object to avoid race conditions
    private final Object lock = new Object();

    public void produce(int value) throws InterruptedException {
        synchronized (lock) {
            while (buffer.size() == maxCapacity) {
                System.out.println("Buffer is full, producer is waiting...");
                lock.wait(); // Wait if the buffer is full
            }
            
            buffer.add(value); // Produce an item
            System.out.println("Produced: " + value);
            lock.notifyAll(); // Notify consumer that an item has been produced
        }
    }

    public int consume() throws InterruptedException {
        synchronized (lock) {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty, consumer is waiting...");
                lock.wait(); // Wait if the buffer is empty
            }

            int value = buffer.remove(); // Consume an item
            System.out.println("Consumed: " + value);
            lock.notifyAll(); // Notify producer that an item has been consumed
            return value;
        }
    }
}
