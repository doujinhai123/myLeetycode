package ClassInit;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void test(List<?> c){

        for (int i=0;i< c.size();i++ ){

            System.out.println(c.get(i));
        }
    }

    public static void main(String args[]){

        ArrayList<String> book = new ArrayList<>();
        book.add("b");
        book.add("a");
        test(book);

        List<Integer> score = new ArrayList<>();
        score.add(90);
        score.add(80);
        test(score);
    }

}

