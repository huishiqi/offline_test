package com.demo.concurrency;

import java.util.List;

public class Producer implements Runnable {
    private final ProducerConsumerQueue<Integer> queue;
    private List<Integer> data;

    public Producer(ProducerConsumerQueue<Integer> queue, List<Integer> data) {
        this.queue = queue;
        this.data = data;
    }

    public boolean produce(Integer element) {
        return queue.put(element);
    }

    @Override
    public void run() {
        for (Integer v: data) {
            boolean ack = queue.put(v);
        }
    }
}
