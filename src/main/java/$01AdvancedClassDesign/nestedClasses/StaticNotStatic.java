package $01AdvancedClassDesign.nestedClasses;

import static $01AdvancedClassDesign.nestedClasses.StaticClass.Nested;
// Or it may be !!! not static import!
// it compiles with both or with each one import
import $01AdvancedClassDesign.nestedClasses.StaticClass.Nested;

/**
 * Created by Dmitrii on 12.01.2018.
 */
public class StaticNotStatic {
    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.str);
    }
}
