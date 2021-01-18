package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class threeThreadprinter {

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
                    Thread.sleep(1000);
                    if(i % 3  == 0) {
                        System.out.println("当前线程为--"+Thread.currentThread().getName() + "----" +i);
                        isB.signalAll();
                        isA.await();
                    }
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
                    Thread.sleep(1000);
                    if(i % 3  == 1) {
                        System.out.println("当前线程为--"+Thread.currentThread().getName() + "----" +i);
                        isC.signalAll();
                        isB.await();
                    }
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
                    Thread.sleep(1000);
                    if(i % 3  == 2) {
                        System.out.println("当前线程为--"+Thread.currentThread().getName() + "----" +i);
                        isA.signalAll();
                        isC.await();
                    }
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
