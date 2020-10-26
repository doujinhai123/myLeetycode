package ThreadBook.chapter02.section01.thread_2_1_1.project_1_t1;

public class Run {
	public static void main(String[] args) {

		System.out.println("进行耗时操作");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		HasSelfPrivateNum numRef = new HasSelfPrivateNum();

		ThreadA athread = new ThreadA(numRef);
		athread.start();

		ThreadB bthread = new ThreadB(numRef);
		bthread.start();


		System.out.println("运行在主线程");

	}
}
