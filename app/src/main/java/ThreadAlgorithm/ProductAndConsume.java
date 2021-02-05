package ThreadAlgorithm;
import java.util.LinkedList;
import java.util.Queue;

public class ProductAndConsume {

	public static void main(String[] args) {
		//生产者 消费者
		Queue<Integer> arrayList = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			ThreadProduct threadProduct = new ThreadProduct(arrayList);
			threadProduct.start();
		}
		for (int i = 0; i < 10; i++) {
			ThreadConsume threadConsume = new ThreadConsume(arrayList);
			threadConsume.start();
		}

		// 生产者 消费者
        LockData lockDta = new LockData();
		ThreadProduceCondition threadProduceCondition = new ThreadProduceCondition(lockDta);
		threadProduceCondition.start();

		ThreadConsumeCondition threadConsumeCondition = new ThreadConsumeCondition(lockDta);
		threadConsumeCondition.start();

	}

}
