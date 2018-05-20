package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 11.01.2018.
 */
public class LocalClass {
    private int first = 1;

    private int multiply() {
        int second = 2; // it is effectivly final variable
        // second++; this statement will fail code compilation
        // as this variable @second should be final or effectively final
        class Inner {
            private int multiply () {
                return first * second;
            }
        }
        return new Inner().multiply();
    }

    private Object getReturnClass() {
        class SimpleLocal {
            // static int i = 1; this is not allowed
            // local classes can't have non-static-final fields
            int i = 0;
            static final int j = 0;
            /*static void printName () {
                System.out.println();
            }*/// static and static+final methods are not allowed
            @Override
            public String toString() {
                return "Inside SimpleLocal class";
            }
        }
        return new SimpleLocal();
    }

    public static void main(String[] args) {
        LocalClass localClass = new LocalClass();
        System.out.println(localClass.multiply());
        // 2

        System.out.println(localClass.getReturnClass());
        // Inside SimpleLocal class
    }
}
