package ClassInit;

public class deadLock {

    public static class A {

        static {
            System.out.println("class A init.");
            B.test();
        }

        public static void test() {
            System.out.println("method test called in class A");
        }
    }

    public static class B {

        static {
            System.out.println("class B init.");
            A.test();
        }

        public static void test() {
            System.out.println("method test called in class B");
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                A.test();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                B.test();
            }
        }).start();
    }
}
