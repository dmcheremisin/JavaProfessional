package $01AdvancedClassDesign.accessModifier;

/**
 * Created by Dmitrii on 25.06.2018.
 */
public class IncrementAndPrivateAccess {
    private int i;

    public static void main(String[] args) {
        int value = 0;
        System.out.println(value++); // 0
        value = 0;
        System.out.println(++value); // 1
    }

    public void modifyOther(IncrementAndPrivateAccess input) {
       input.i = 20; // it is legal in class IncrementAndPrivateAccess
    }
}
