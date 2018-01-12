package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 12.01.2018.
 */
public class StaticClass {
    private String name = "StaticClass";
    public static class Nested {
        private int price = 1;
        public String str = "New name";

        private void printOuter() {
            System.out.println(new StaticClass().name);
        }
        private void printName(String nestedName){
            System.out.println(nestedName);
        }
    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
        // 1
        String nestedName = "Nested";
        nestedName += "!"; // not effectively final and it is ok
        nested.printName(nestedName);
        // Nested!

        StaticClass staticClass = new StaticClass();
        staticClass.printInner(nested, "Hello");
        // Hello!

        nested.printOuter();
        // StaticClass
    }
    private void printInner(Nested nested, String name) {
        name += "!";// not effectively final variable
        nested.printName(name);
    }
}
