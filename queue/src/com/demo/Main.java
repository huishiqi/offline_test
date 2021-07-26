package com.demo;

import com.demo.concurrency.Consumer;
import com.demo.concurrency.Producer;
import com.demo.concurrency.ProducerConsumerQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProducerConsumerQueue<Integer> queue = new ProducerConsumerQueue<>(16);
        List<Integer> data = generateData();

        Producer producer = new Producer(queue, data);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }

    public static List<Integer> generateData() {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(6);
        data.add(7);
        return data;
    }
}
