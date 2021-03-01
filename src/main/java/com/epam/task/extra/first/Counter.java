package com.epam.task.extra.first;

public class Counter {

    private int count;

    public synchronized void increment() {
        this.count++;
    }

    public synchronized int getCount() {
        return this.count;
    }

}
