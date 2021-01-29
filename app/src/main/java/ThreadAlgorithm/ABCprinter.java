package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


import java.util.concurrent.locks.Lock;

public class ABCprinter {

    private static final Lock lock = new ReentrantLock();
    private static final Condition isA = lock.newCondition();
    private static final Condition isB = lock.newCondition();
    private static final Condition isC = lock.newCondition();

    static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    System.out.println("A");
                    isB.signal();
                    Thread.sleep(1000);
                    isA.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    System.out.println("B");
                    isC.signal();
                    Thread.sleep(1000);
                    isB.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    System.out.println("C");
                    isA.signal();
                    Thread.sleep(1000);
                    isC.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.join();
        b.join();
        c.join();
        a.start();
        b.start();
        c.start();

    }
}
