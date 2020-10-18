package mutileThread.part1.other.synchronizedObject;

//suspend��resume������ȱ��--��ռ  
public class SynchronizedObject2 {

	synchronized public void printString(){
		System.out.println("printString������ʼִ��");
		if(Thread.currentThread().getName().equals("a")){
			Thread.currentThread().suspend();//���߳���ͣ
			System.out.println("����Ϊa���߳���Զsuspend��");
		}
		System.out.println("printString��������");
	}
	
}
