package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class printerJiou {
    static boolean flag = false;

    public static void main(String[] args) {
//        //方式1 通过reentrantLock
//        ReentrantLock reentrantLock = new ReentrantLock();
//        Condition conditionA = reentrantLock.newCondition();
//        Condition conditionB = reentrantLock.newCondition();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLock.lock();
//                try {
//                    for (int i = 0; i < 100; i++) {
//                        if (i % 2 == 0) {
//                            System.out.println("打印的为偶数" + i);
//                            conditionB.signalAll();
//                            conditionA.await();
//                        }
//
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reentrantLock.lock();
//                try {
//                    for (int i = 0; i < 100; i++) {
//                        if (i % 2 == 1) {
//                            System.out.println("打印的为奇数" + i);
//                            conditionA.signalAll();
//                            conditionB.await();
//                        }
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }).start();

        //方式2通过对象锁
        Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(200);
                            if (i % 2 == 0) {
                                System.out.println("打印偶数线程为i----" + i);
                                object.notify();
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(200);
                            if (i % 2 == 1) {
                                System.out.println("打印奇数线程为i----" + i);
                                object.notify();
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

