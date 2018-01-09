package staticVSdynamic;

/**
 * Created by Dmitrii on 09.01.2018.
 */
class A {
    public void method1() {
        getClassName1();
    }
    public void getClassName1() {
        System.out.println("A class");
    }
    // -------------------------
    public void method2() {
        getClassName2();
    }
    private void getClassName2() { // static binding during compile time
        System.out.println("A class");
    }
}

class B extends A {
    public void getClassName1() {
        System.out.println("B class");
    }
    // ---------------------------
    private void getClassName2() {
        System.out.println("B class");
    }
}

public class AccessModifierBinding extends A {
    public static void main(String[] args) {
        A a = new B();
        a.method1();
        a.method2();
        // B class
        // A class
        System.out.println();
    }
}

