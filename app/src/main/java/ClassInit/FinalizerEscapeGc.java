package ClassInit;

public class FinalizerEscapeGc {

    public static FinalizerEscapeGc SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes i am still alive  :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        FinalizerEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception{
        SAVE_HOOK = new FinalizerEscapeGc();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法的优先级很低，所以睡一下
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no i am dead");
        }


        //第二次自救失败
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法的优先级很低，所以睡一下
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no i am dead");
        }
    }
}