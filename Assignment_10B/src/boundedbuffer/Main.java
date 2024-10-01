package boundedbuffer;

public class Main {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) { // Produce 20 items
                try {
                    buffer.produce(i);
                    Thread.sleep(100); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 20; i++) { // Consume 20 items
                try {
                    buffer.consume();
                    Thread.sleep(150); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
