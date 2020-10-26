package ThreadAlgorithm;

public class SingInstance {
    private static volatile SingInstance singInstance = null;
    private SingInstance() {
        System.out.println("只会运行一次");
    }

    public static SingInstance getSingInstance() {
        System.out.println("进入的判断条件"+Thread.currentThread().getName());
        if(singInstance == null) {
            System.out.println("进入了等于null的判断条件"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingInstance.class) {
                System.out.println("开始生成了的新的实例"+Thread.currentThread().getName());
                if(singInstance == null) {
                    singInstance = new SingInstance();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("结束生成了的新的实例"+Thread.currentThread().getName());
                }
            }
        }
        return singInstance;
    }
    private static class InnerStaticInstance{
        static SingInstance singInstance = new SingInstance();

    }
    public static SingInstance  getInstance() {
       return  InnerStaticInstance.singInstance;
    }
}
