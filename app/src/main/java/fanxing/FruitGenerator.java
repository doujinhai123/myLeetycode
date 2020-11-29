package fanxing;

abstract class FruitGenerator<T> implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
    private T key;

    public FruitGenerator(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public <E> void show_3(E t){
        System.out.println(t.toString());
    }
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }
    public <T extends Number> T showKeyName(FruitGenerator<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }
}