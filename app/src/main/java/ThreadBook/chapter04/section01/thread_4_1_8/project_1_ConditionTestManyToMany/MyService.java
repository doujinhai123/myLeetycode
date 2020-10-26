package ThreadBook.chapter04.section01.thread_4_1_8.project_1_ConditionTestManyToMany;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class MyService {

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;

	public void set() {
		try {
			lock.lock();
			while (hasValue == true) {
				System.out.println("seet线程进入wait");
//				System.out.println("有可能★★连续");
//				System.out.println("setsetsetsetste、waiwaiwaiwaiwaiwasiw" +  Thread.currentThread().getName());
				condition.await();
				System.out.println("set获取锁从wait脱离");
			}
			System.out.println("打印★");
			hasValue = true;
			condition.signal();
			Thread.sleep(2000);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		try {
			lock.lock();
			while (hasValue == false) {
				System.out.println("get线程还是进入wait");
//				System.out.println("有可能☆☆连续");
//				System.out.println("getgetegtegeyegyegeyewauwaiwaiwaiwaiwaiwiaiwaiwiwiw" +  Thread.currentThread().getName());
				condition.await(300000,MILLISECONDS);
				System.out.println("get获取锁从wait脱离");
			}
			System.out.println("打印☆");
			hasValue = false;
//			condition.signal();
			Thread.sleep(2000);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
