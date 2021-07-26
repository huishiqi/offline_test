package com.demo.concurrency;

public class Consumer implements Runnable {
    private final ProducerConsumerQueue<Integer> queue;

    public Consumer(ProducerConsumerQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer element = null;
            try {
                element = queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(element);
        }
    }
}
