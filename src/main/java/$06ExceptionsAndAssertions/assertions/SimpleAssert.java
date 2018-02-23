package $06ExceptionsAndAssertions.assertions;

/**
 * Created by Dmitrii on 24.02.2018.
 */
public class SimpleAssert {
    public static void main(String[] args) {
        int num = -5;
        assert num > 0 : "Number is lower than zero!";
        System.out.println(num);
        // java -ea SimpleAssert:
        // Exception in thread "main" java.lang.AssertionError: Number is lower than zero!

        // java SimpleAssert
        // -5
    }
}
