package ThreadAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ThreadProduct extends Thread {
    Queue mArrayList = new LinkedList();

    public ThreadProduct(Queue<Integer> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            synchronized (mArrayList) {
                while (mArrayList.size() == 10) {
                    System.out.println("生产已经满啦 进入wait、" +  Thread.currentThread().getName());
                    try {
                        System.out.println("生产已经满啦" + + mArrayList.size());
                        mArrayList.wait();
                        System.out.println("唤醒啦继续生产 剩余个人数" + mArrayList.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mArrayList.add("123");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {

                }
                System.out.println("生产中 " +  Thread.currentThread().getName());
                System.out.println("生产啦，剩余的个数为" + mArrayList.size());
                mArrayList.notifyAll();

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
