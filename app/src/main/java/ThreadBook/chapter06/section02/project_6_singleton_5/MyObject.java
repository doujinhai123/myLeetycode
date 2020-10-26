package ThreadBook.chapter06.section02.project_6_singleton_5;

public class MyObject {
	
	private volatile static MyObject myObject;

	private MyObject() {
	}

	// 使用双检测机制来解决问题
	// 即保证了不需要同步代码的异步
	// 又保证了单例的效果
	public static MyObject getInstance() {
		try {
			if (myObject != null) {
			} else {
				// 模拟在创建对象之前做一些准备性的工
				System.out.println("进入了等于null的判断条件"+Thread.currentThread().getName());
				synchronized (MyObject.class) {
					System.out.println("开始生成了的新的实例"+Thread.currentThread().getName());
					if (myObject == null) {
						Thread.sleep(3000);
						myObject = new MyObject();
						System.out.println("结束生成了的新的实例"+Thread.currentThread().getName());
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return myObject;
	}
	// 此版本的代码称为：
	// 双重检查Double-Check Locking


}
