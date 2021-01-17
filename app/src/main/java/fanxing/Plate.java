package fanxing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Plate<T> {
    private T item;

    public Plate(T aa) {
        this.item = aa;
    }

    public void setItem(T aa) {
        this.item = aa;
    }

    public T getItem() {
        return item;
    }


    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Fruit>(new Apple());
       Apple sss = (Apple) p.getItem();


        List<? super Fruit> flist = new ArrayList<Fruit>();
        flist.add(new Fruit());
        flist.add(new Apple());
        Apple ftuit = (Apple) flist.get(0);



       System.out.println(ftuit.getCount());
    }
}

