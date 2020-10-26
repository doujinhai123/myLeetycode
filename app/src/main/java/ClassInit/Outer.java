package ClassInit;

public class Outer {
    private Outer() {
        System.out.println("outer instance create");
    }

    static {
        System.out.println("outer init");
    }

    public static void main(String[] args) {
        System.out.println("outer main execute");
               Outer outer = Inner.outer;
    }

    private static class Inner {
        static {
            System.out.println("inner init");
        }

        private static final Outer outer = new Outer();
    }
}