package $01AdvancedClassDesign.nestedClasses;

import java.util.stream.Stream;

/**
 * Created by Dmitrii on 11.01.2018.
 */
public class MemberInner {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;
        // static int i = 0; inner class can't have static declarations
        /*static void myMethod() {
            System.out.println("Inner");
        }*/// static methods are not allowed
        public void go(int j) {
            Stream.iterate(0, i -> i++).limit(repeat).forEach(i -> System.out.println(greeting));
            // OR
            Stream.generate(() -> greeting).limit(repeat).forEach(i -> System.out.println(greeting));
        }
    }

    public void innerGo() {
        Inner inner = new Inner();
        inner.go(1);
    }

    public static void main(String[] args) {
        MemberInner outer = new MemberInner();
        Inner inner = outer.new Inner();
        int i = 1;
        i++;// variable is not final and it is ok
        inner.go(i);
        outer.innerGo();
    }
}
