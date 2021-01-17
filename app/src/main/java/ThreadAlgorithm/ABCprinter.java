package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import ThreadBook.chapter02.section01.thread_2_1_1.project_1_t1.ThreadA;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCprinter {

    private static final Lock lock=new ReentrantLock();
    private static final Condition isA=lock.newCondition();
    private static final Condition isB=lock.newCondition();
    private static final Condition isC=lock.newCondition();

    static class ThreadA extends Thread {

        @Override
        public void run() {
            while(true){
                lock.lock();
                System.out.println("A");
                isB.signal();
                try {
                    Thread.sleep(1000);
                    isA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            while(true){
                lock.lock();
                System.out.println("B");
                isC.signal();
                try {
                    Thread.sleep(1000);
                    isB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            while(true){
                lock.lock();
                System.out.println("C");
                isA.signal();
                try {
                    Thread.sleep(1000);
                    isC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadA a=new ThreadA();
        ThreadB b=new ThreadB();
        ThreadC c=new ThreadC();
        a.join();
        b.join();
        c.join();
        a.start();
        b.start();
        c.start();

    }
}
