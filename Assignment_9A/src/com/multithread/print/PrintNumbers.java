package com.multithread.print;

public class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            Thread thread = new Thread(new PrintTask(i));
            thread.start();
            try {
                thread.join();  // Ensures each thread finishes before the next starts
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
