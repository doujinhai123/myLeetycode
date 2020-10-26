package ThreadBook.chapter04.section01.thread_4_1_8.project_1_ConditionTestManyToMany;

public class MyThreadB extends Thread {

	private MyService myService;

	public MyThreadB(MyService myService) {
		super();
		this.myService = myService;
	}

	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			myService.get();
		}
	}

}
