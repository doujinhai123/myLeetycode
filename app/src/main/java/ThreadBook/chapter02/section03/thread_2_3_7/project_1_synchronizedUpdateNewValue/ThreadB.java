package ThreadBook.chapter02.section03.thread_2_3_7.project_1_synchronizedUpdateNewValue;

public class ThreadB extends Thread {
	private Service service;

	public ThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		service.stopMethod();
	}

}
