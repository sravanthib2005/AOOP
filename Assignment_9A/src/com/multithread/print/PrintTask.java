package com.multithread.print;

public class PrintTask implements Runnable {
    private int number;

    public PrintTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number % 2 == 0) {
            printTwo();
        } else if (number % 3 == 0) {
            printThree();
        } else if (number % 4 == 0) {
            printFour();
        } else if (number % 5 == 0) {
            printFive();
        } else {
            printNumber();
        }
    }

    private void printTwo() {
        System.out.println("Divisible by 2: " + number);
    }

    private void printThree() {
        System.out.println("Divisible by 3: " + number);
    }

    private void printFour() {
        System.out.println("Divisible by 4: " + number);
    }

    private void printFive() {
        System.out.println("Divisible by 5: " + number);
    }

    private void printNumber() {
        System.out.println("Number: " + number);
    }
}
