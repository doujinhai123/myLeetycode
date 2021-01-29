package ThreadAlgorithm;
import java.util.LinkedList;
import java.util.Queue;

public class Run {

	public static void main(String[] args) {
		Queue<Integer> arrayList = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			ThreadProduct threadProduct = new ThreadProduct(arrayList);
			threadProduct.start();
		}
		for (int i = 0; i < 10; i++) {
			ThreadConsume threadConsume = new ThreadConsume(arrayList);
			threadConsume.start();
		}
//        LockData lockDta = new LockData();
//		ThreadProduceCondition threadProduceCondition = new ThreadProduceCondition(lockDta);
//		threadProduceCondition.start();
//
//		ThreadConsumeCondition threadConsumeCondition = new ThreadConsumeCondition(lockDta);
//		threadConsumeCondition.start();
//
//
//		MyThread t1 = new MyThread();
//		MyThread t2 = new MyThread();
//		MyThread t3 = new MyThread();
//
//		t1.start();
//		t2.start();
//		t3.start();



	}

}
