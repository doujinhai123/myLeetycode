package ClassInit;

import java.util.concurrent.TimeUnit;

//public class TestClassLoading {
// 7     public static class A{
// 8         static {
// 9             System.out.println("class A init");
//10             try {
//11                 TimeUnit.SECONDS.sleep(1);
//12             } catch (InterruptedException e) {
//13                 e.printStackTrace();
//14             }
//15             new B();
//16         }
//17
//18         public static void test() {
//19             System.out.println("aaa");
//20         }
//21     }
//22
//23     public static class B{
//24         static {
//25             System.out.println("class B init");
//26             new A();
//27         }
//28
//29
//30         public static void test() {
//31             System.out.println("bbb");
//32         }
//33     }
//34     public static void main(String[] args) {
//35         new Thread(() -> A.test()).start();
//36         new Thread(() -> B.test()).start();
//37     }
//38 }