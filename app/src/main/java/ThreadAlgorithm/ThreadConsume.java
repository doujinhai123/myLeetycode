package ThreadAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ThreadConsume extends Thread {
    Queue mArrayList = new LinkedList();

    public ThreadConsume(Queue<Integer> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            synchronized (mArrayList) {
                while (mArrayList.size() == 0) {
                    try {
                        System.out.println("都消费完毕了 进入wait" + Thread.currentThread().getName());
                        mArrayList.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {

                }
                mArrayList.poll();
                System.out.println("消费啦，剩余的个数为" + mArrayList.size()+"---"+ Thread.currentThread().getName());
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
