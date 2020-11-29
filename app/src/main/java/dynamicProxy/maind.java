package dynamicProxy;

import android.util.Log;

import java.lang.reflect.Proxy;

class maind {
    private int i;

    public static void main(String[] args) {
        DynamicProxy inter = new DynamicProxy(new Vendor());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取代理类实例sell
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();
        caclulae();

        try {
            caclulae();
        } catch (Exception e) {
            System.out.println("outeouterouterouterouterrExceptionExceptionExceptionExceptionException");
        } finally {
            System.out.println("outeouterouterouterouterrfinallyfinallyfinally");
        }


    }

   public static void caclulae () {
        try {
            int i = 4 / 0;
        } catch (Exception e) {
            System.out.println("ExceptionException");
        } finally {
            System.out.println("doujinhaifinalllyfinalllyfinalllyfinallly");
        }
    }
}
