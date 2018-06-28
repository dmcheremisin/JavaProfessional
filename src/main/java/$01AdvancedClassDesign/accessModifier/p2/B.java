package $01AdvancedClassDesign.accessModifier.p2;

/**
 * Created by Dmitrii on 28.06.2018.
 */
import $01AdvancedClassDesign.accessModifier.p1.A;

public class B extends A {
    public void process(A a) {
        // a.i = a.i * 2; // -> doesn't compile because B doesn't have access to A's i field
    }

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        b.process(a);
        System.out.println(a.getI());
    }
}
