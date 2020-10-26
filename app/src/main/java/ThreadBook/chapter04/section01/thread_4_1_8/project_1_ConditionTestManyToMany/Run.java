package ThreadBook.chapter04.section01.thread_4_1_8.project_1_ConditionTestManyToMany;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();

		MyThreadA[] threadA = new MyThreadA[10];
		MyThreadB[] threadB = new MyThreadB[10];

		for (int i = 0; i < 1; i++) {
			threadA[i] = new MyThreadA(service);
			threadB[i] = new MyThreadB(service);
			threadB[i].start();
			Thread.sleep(200);
			threadA[i].start();

		}

	}
}
