package ThreadAlgorithm;

import java.util.ArrayList;
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



	}

}
