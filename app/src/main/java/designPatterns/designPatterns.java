package designPatterns;

public class designPatterns {
    public static void main(String[] args) {
        SingleInstance.getSingleInstance();
        Singleton.getInstance();
    }
}

class SingleInstance {
    private static volatile SingleInstance singleInstance;
    private SingleInstance() {
    }
    public static SingleInstance getSingleInstance() {
        if(singleInstance == null) {
            synchronized (SingleInstance.class) {
                if(singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;

    }
}
//静态内部类
 class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
