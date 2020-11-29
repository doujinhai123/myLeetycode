package fanxing;

public class JavaFanXing {

    public static void main(String[] args) {
        Father father = new Father("3");
        FruitGenerator<Father> fatherFruitGenerator = new FruitGenerator<Father>(father) {
            @Override
            public Father next() {
                return super.next();
            }
        };
        Son son  = new Son("4");
        FruitGenerator<Son> sonFruitGenerator = new FruitGenerator<Son>(son) {
            @Override
            public Son next() {
                return super.next();
            }
        };
        FruitGenerator<String> fatherFruitGeneratorss = new FruitGenerator<String>("3") {
            @Override
            public String next() {
                return super.next();
            }
        };
//        FruitGenerator<Son>  fruitGenerator = (FruitGenerator<Son>) showKeyValue1(fatherFruitGenerator);
//        showKeyValue1(sonFruitGenerator);
        showKeyValue1(fatherFruitGeneratorss);


    }

    private static FruitGenerator<?> showKeyValue1(FruitGenerator<?> fatherFruitGenerator) {
        String  ss = (String) fatherFruitGenerator.getKey();
        System.out.println(ss);
        return  fatherFruitGenerator;
    }

//    private static void showKeyValue1(FruitGenerator<? extends Father> fatherFruitGenerator) {
//        Father father = fatherFruitGenerator.getKey();
//        Son son = (Son) father;
//        son.getS();
//    }


}