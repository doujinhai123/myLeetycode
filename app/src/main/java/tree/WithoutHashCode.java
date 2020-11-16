package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class Key {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Key(Integer id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Key)) {
            return false;
        } else {
            return this.getId().equals(((Key) o).getId());
        }
    }

    public int hashCode() {
        return id.hashCode();
    }
}

public class WithoutHashCode {
    public static void main(String[] args) {
//        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75f,true);
//        map.put("apple", "苹果");
//        map.put("watermelon", "西瓜");
//        map.put("banana", "香蕉");
//        map.put("peach", "桃子");
////
//
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//
//        map.get("banana");
//        map.get("apple");
//        Iterator iters = map.entrySet().iterator();
//        while (iters.hasNext()) {
//            Map.Entry entry = (Map.Entry) iters.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }

        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("Linux");
        books.add("C++");
        books.add("算法");
        System.out.println(books);
        // 删除 Java
        books.remove("Java");
        // 重新添加 Java
        books.add("Java");
        System.out.println(books);

    }
}