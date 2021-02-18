package designPatterns.dynamicProxy;

class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("In sell method");
    }

    @Override
    public void ad() {
        System.out.println("In ad method");
    }
}
