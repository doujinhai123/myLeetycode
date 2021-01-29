package ThreadAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class printerJiou {
    static boolean flag = false;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                        if(i%2 == 0) {
                            System.out.println("打印的是偶数---------" + i);
                            conditionA.await();
                        } else {
                            conditionB.signalAll();
                        }



                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <100 ; i++) {
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                        if(i%2 != 0) {
                            System.out.println("打印的是ji数---------" + i);
                            conditionB.await();
                        } else {
                            conditionA.signalAll();
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