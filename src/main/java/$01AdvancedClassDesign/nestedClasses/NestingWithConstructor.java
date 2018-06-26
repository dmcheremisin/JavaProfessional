package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 23.06.2018.
 */
public class NestingWithConstructor {
    public static void main(String args[]) {
        B.C obj = new B().new C();
        // b
        // c
        // d
        System.out.println(obj.c); // c
        System.out.println(((A) obj).c);//d
    }
}
class A {
    char c;
    A(char c) {
        this.c = c;
    }
}
class B extends A {
    char c = 'b';
    B() {
        super('a');
    }
    class C extends A {
        char c = 'c';
        C() {
            super('d');
            System.out.println(B.this.c); // b
            System.out.println(C.this.c); // c
            System.out.println(super.c);  // d
        }
    }
}