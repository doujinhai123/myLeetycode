package ThreadAlgorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test3 {
    private static Integer count = 0;
    //创建一个阻塞队列
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3.new Producer()).start();
        new Thread(test3.new Consumer()).start();
//        new Thread(test3.new Producer()).start();
//        new Thread(test3.new Consumer()).start();
//        new Thread(test3.new Producer()).start();
//        new Thread(test3.new Consumer()).start();
//        new Thread(test3.new Producer()).start();
//        new Thread(test3.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.put(1);
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + blockingQueue.size());
            }
        }
    }
}