package $01AdvancedClassDesign.staticVSdynamic;

/**
 * Created by Dmitrii on 09.01.2018.
 */
class One {}
class Two extends One {}

public class StaticBinding {

    public static void main(String[] args) {
        StaticBinding staticBinding = new StaticBinding();
        One one = new Two();
        test(one);
        // One class
        // class $01AdvancedClassDesign.staticVSdynamic.Two
        staticBinding.verify(one);
        // One class
        // class $01AdvancedClassDesign.staticVSdynamic.Two
    }

    static void test(One obj) {
        System.out.println("One class");
        System.out.println(obj.getClass());
    }

    static void test(Two obj) {
        System.out.println("Two class");
        System.out.println(obj.getClass());
    }

    void verify(One obj) {
        System.out.println("One class");
        System.out.println(obj.getClass());
    }

    void verify(Two obj) {
        System.out.println("Two class");
        System.out.println(obj.getClass());
    }
}
