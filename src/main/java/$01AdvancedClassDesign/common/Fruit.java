package $01AdvancedClassDesign.common;

/**
 * Created by Dmitrii on 01.07.2018.
 */
interface Eatable {
    int types = 10;
}

class Food implements Eatable {
    public static int types = 20;
}

public class Fruit extends Food implements Eatable {//it is normal to implement interface twice from parent class and itself
    public static void main(String[] args) {
        //types = 30; // Error:(16, 9) java: reference to types is ambiguous
        //both variable types in $01AdvancedClassDesign.common.Food and
        // variable types in $01AdvancedClassDesign.common.Eatable match

        //System.out.println(types); //Error:(16, 9) java: reference to types is ambiguous
        //both variable types in $01AdvancedClassDesign.common.Food and
        // variable types in $01AdvancedClassDesign.common.Eatable match
    }
}