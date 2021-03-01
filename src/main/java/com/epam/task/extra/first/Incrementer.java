package com.epam.task.extra.first;

import java.util.stream.IntStream;

public class Incrementer implements Runnable {

    private final static int INCREMENT_NUMBER = 100;

    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, INCREMENT_NUMBER).forEach(number -> {
            counter.increment();
        });
    }

}
