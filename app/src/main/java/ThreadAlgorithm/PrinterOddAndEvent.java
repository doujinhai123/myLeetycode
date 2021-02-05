package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterOddAndEvent {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                        for (int i = 0; i < 100; i++) {
                            if(i % 2 == 0) {
                                System.out.println("打印的为偶数"+i );
                                conditionA.await();
                            }
                            conditionB.signalAll();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                        for (int i = 0; i < 100; i++) {
                            if(i % 2  == 1) {
                                System.out.println("打印的为奇数"+i);
                                conditionB.await();
                            }
                            conditionA.notifyAll();

                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }).start();

    }
}
