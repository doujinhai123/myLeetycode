package ThreadAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class LockData {
    Queue<Integer> arrayList = new LinkedList<>();
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition productCondition = reentrantLock.newCondition();
    Condition consumeCondition = reentrantLock.newCondition();
}
