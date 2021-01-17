package ThreadAlgorithm;



class ThreadConsumeCondition extends Thread {
    LockData mLockData;

    public ThreadConsumeCondition(LockData lockData) {
        this.mLockData = lockData;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mLockData.reentrantLock.lock();
            while (mLockData.arrayList.size() == 0) {
                try {
                    System.out.println("都消费完毕了 进入wait" + Thread.currentThread().getName());
                    mLockData.consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mLockData.arrayList.poll();
            System.out.println("消费啦，剩余的个数为" +      mLockData.arrayList+"---"+ Thread.currentThread().getName());
            mLockData.productCondition.signalAll();
            mLockData.reentrantLock.unlock();

        }

    }
}
