package $01AdvancedClassDesign.enums;

import static $01AdvancedClassDesign.enums.Animals.Cat;
import static $01AdvancedClassDesign.enums.Animals.Cow;
import static $01AdvancedClassDesign.enums.Animals.Dog;

/**
 * Created by Dmitrii on 10.01.2018.
 */
enum Animals {
    Cat{
        @Override
        public void makeNoise() {
            System.out.println("MURRRRR....");
        }
    },
    Dog {
        @Override
        public void makeNoise() {
            System.out.println("WUAF-WUAF....");
        }
    },
    Cow;

    public void makeNoise() {
        System.out.println("MUUUUUUU");
    }
}
public class MethodOverride{
    public static void main(String[] args) {
        Cat.makeNoise();
        Dog.makeNoise();
        Cow.makeNoise();
    }
}
