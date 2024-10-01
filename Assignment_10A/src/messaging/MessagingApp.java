// File: messaging/MessagingApp.java
package messaging;

public class MessagingApp {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);  // Buffer with capacity 5

        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start both threads
        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();  // Wait for producer to finish
            consumerThread.join();  // Wait for consumer to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Message exchange completed.");
    }
}
