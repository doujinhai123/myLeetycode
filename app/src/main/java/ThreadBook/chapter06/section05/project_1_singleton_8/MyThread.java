package ThreadBook.chapter06.section05.project_1_singleton_8;

import ThreadAlgorithm.SingInstance;

public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			SingInstance.getInstance();
//			System.out.println(MyObject.getInstance().hashCode());
		}
	}
}
