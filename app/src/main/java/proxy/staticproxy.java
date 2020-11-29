package proxy;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

class staticproxy {
    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();

        ArrayList<String> linkedList = new ArrayList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        ArrayList<String > ss = (ArrayList<String>) linkedList.clone();
        if(linkedList == ss) {
            System.out.println("onCreate:sssss 相等的对象");
        } else  {
            System.out.println("onCreate:sssss BU相等的对象");
        }
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("onCreate:sssss "+linkedList.hashCode());
        }

        for (int i = 0; i < ss.size(); i++) {
            System.out.println("onCreate:1111111 "+ss.hashCode());
        }
    }


}
