package ThreadAlgorithm;


class ThreadProduceCondition extends Thread {
    LockData mLockData;
    public ThreadProduceCondition(LockData lockData) {
        this.mLockData = lockData;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            mLockData.reentrantLock.lock();
            while (mLockData.arrayList.size() == 5) {
                try {
                    System.out.println("生产已经满啦 进入wait、" +  Thread.currentThread().getName());
                    mLockData.productCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mLockData.arrayList.add(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("继续生产 剩余个人数" + mLockData.arrayList);
            mLockData.consumeCondition.signalAll();
            mLockData.reentrantLock.unlock();

        }
    }
}
