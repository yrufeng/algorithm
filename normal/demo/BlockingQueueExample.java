package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueExample {

    private Queue<Integer> queue;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;

    public BlockingQueueExample() {
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    // 入队操作
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == queue.capacity()) {
                notFull.await();
            }
            queue.offer(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 出队操作
    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int element = queue.poll();
            notFull.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    // 获取队列大小
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    // 设置队列容量
    public void setCapacity(int capacity) {
        this.queue.capacity = capacity;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueExample queue = new BlockingQueueExample();

        // 启动多个生产者线程
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 5; j++) {
                    try {
                        queue.enqueue(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 启动一个消费者线程
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int element = queue.dequeue();
                    System.out.println("消费: " + element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
