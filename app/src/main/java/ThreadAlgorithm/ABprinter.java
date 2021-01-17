package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ABprinter {
    static boolean flag = false;
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
                        Thread.sleep(2000);
                        System.out.println("AAAAA");
                        conditionB.signalAll();
                        conditionA.await();

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
                        Thread.sleep(2000);
                        System.out.println("BBBB");
                        conditionA.signalAll();
                        conditionB.await();

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
