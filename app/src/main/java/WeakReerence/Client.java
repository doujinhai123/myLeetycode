package WeakReerence;

import java.lang.ref.WeakReference;

import ClassInit.deadLock;

/**
 * Main class
 *
 * @author BrightLoong
 * @date 2018/5/24
 */
public class Client {
    public static void main(String[] args) {
        Apple apple = new Apple("shili");
//        Salad salad = new Salad(apple);
        //通过WeakReference的get()方法获取Apple
        WeakReference<Apple> weakReference = new WeakReference<>(apple);
        Apple apple1 = weakReference.get();
        System.out.println("Apple:" + weakReference.get()+ "大小为" + weakReference.get());
        System.gc();
        try {
            //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //如果为空，代表被回收了
        if (weakReference.get() == null) {
            System.out.println("clear Apple。");
        }
    }
}
