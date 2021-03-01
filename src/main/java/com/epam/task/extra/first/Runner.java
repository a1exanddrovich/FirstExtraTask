package com.epam.task.extra.first;

import java.util.ArrayList;

public class Runner {

    private final static int THREADS_NUMBER = 10;

//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ArrayList<Future<?>> futures = new ArrayList<>();
//        final Counter counter = new Counter();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < THREADS_NUMBER; i++) {
//            Runnable runnable = new Incrementer(counter);
//            Future<?> future = executorService.submit(runnable);
//            futures.add(future);
//        }
//        for (Future<?> future : futures) {
//            future.get();
//        }
//        executorService.shutdown();
//        int result = counter.getCount();
//        System.out.println("The result is " + result);
//    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        final Counter counter = new Counter();
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Incrementer incrementer = new Incrementer(counter);
            Thread thread = new Thread(incrementer);
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads) {
            thread.join();
        }
        int result = counter.getCount();
        System.out.println("The result is " + result);
    }

}
