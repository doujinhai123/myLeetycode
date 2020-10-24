package ThreadBook.chapter03.section01.therad_3_1_11.project_7_stack_3;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List list = new ArrayList();

	synchronized public void push() {
		try {
			while (list.size() == 1) {
				System.out.println("push操作中的："
						+ Thread.currentThread().getName() + " 线程呈wait状态");
				this.wait();
			}
			list.add("anyString=" + Math.random());
			this.notifyAll();
			Thread.sleep(1000);
			System.out.println("push=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public String pop() {
		String returnValue = "";
		try {
			while (list.size() == 0) {
				System.out.println("pop操作中的："
						+ Thread.currentThread().getName() + " 线程呈wait状态");
				this.wait();
			}
			returnValue = "" + list.get(0);
			list.remove(0);
			this.notifyAll();
			Thread.sleep(1000);
			System.out.println("pop=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
