package com.demo.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerQueue<E> {
    private final Queue<E> queue = new LinkedList<>();
    private int maxSize = 20;
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition producer = lock.newCondition();
    private final Condition consumer = lock.newCondition();

    public ProducerConsumerQueue() {
    }

    public ProducerConsumerQueue(int size) {
        this.maxSize = size;
    }

    public boolean put(E element) {
        if (element == null) {
            return false;
        }
        boolean ack = false;
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                producer.await();
            }
            queue.add(element);
            ack = true;
            count++;
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return ack;
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                consumer.await();
            }
            count--;
            producer.signalAll();
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
