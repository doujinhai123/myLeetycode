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
        synchronized (mArrayList) {
            while (true) {
                while (mArrayList.size() == 0) {
                    try {
                        System.out.println("都消费完毕了，需要wait");
                        mArrayList.notifyAll();
                        mArrayList.wait();
                        System.out.println("又有啦，继续消费，需要wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                mArrayList.poll();
                System.out.println("消费啦，剩余的个数为"+mArrayList.size());
            }


        }
    }
}
