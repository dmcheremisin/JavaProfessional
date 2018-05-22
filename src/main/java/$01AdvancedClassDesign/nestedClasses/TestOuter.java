package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 22.05.2018.
 */
public class TestOuter {
    public class TestInner {}

    public void myOuterMethod() {
        this.new TestInner();
        new TestInner();
    }
    public static void main(String[] args) {
        TestOuter to = new TestOuter();       // 2
        to.new TestInner();
        // this.new TestInner(); -> no this in the static context
    }
}
