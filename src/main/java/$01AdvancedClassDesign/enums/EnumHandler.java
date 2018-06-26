package $01AdvancedClassDesign.enums;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by Dmitrii on 10.01.2018.
 */
enum Seasons {
    SPRING, SUMMER, AUTUMN, WINTER
    // semicolon ; is not required at the end
}

// it is not possible to extend an enum
// enum SeasonsShort extends Seasons {}
// implement interface is legal
enum SeasonsLong implements Function<String, Integer> {
    // String seasonName; fields should go after enum values declaration

    SPRING("spring", 10), SUMMER("summer", 30), AUTUMN("autumn", 20), WINTER("winter", 40);
    // semicolon ; is required at the end

    String seasonName;
    int visitors;
    static String prefix = "Season: ";

    SeasonsLong(String seasonName, int visitors) {
        // Unlike a regular java class, you cannot access a non-final static field from an enum's constructor. ( JLS 8.9.2 )
        //this.seasonName = prefix + seasonName;
        this.seasonName = seasonName;
        this.visitors = visitors;
    }

    @Override
    public String toString() {
        return prefix + this.seasonName + " visitors: " + this.visitors;
    }

    int getVisitors() {
        return this.visitors;
    }

    @Override
    public Integer apply(String s) {
        return s != null ? s.length() : 0;
    }
}

public class EnumHandler {
    public static void main(String[] args) {
        System.out.println(Seasons.WINTER);
        System.out.println(SeasonsLong.WINTER);
        // WINTER
        // winter visitors: 40 - because toString is overriden, otherwise would be WINTER

        System.out.println(SeasonsLong.WINTER.getVisitors());
        // 40

        // iteration over all enum values
        Arrays.stream(Seasons.values()).forEach(System.out::println);

        // construction of enum from a string
        SeasonsLong winter = SeasonsLong.valueOf("WINTER");
        System.out.println(winter);

        //SeasonsLong winterWrong = SeasonsLong.valueOf("winter");
        // Exception in thread "main" java.lang.IllegalArgumentException: No enum constant $01AdvancedClassDesign.enums.SeasonsLong.winter
        // valueOf is case sensitive => we have only uppercase WINTER enum value

        System.out.println(winter == SeasonsLong.WINTER);
        // true
        // enums may be compared by == operator

        switch (winter) {
            // enum value should be unqualified constant
            // case SeasonsLong.SPRING:
            case SUMMER:
                System.out.println("Lets go to the beach!");
                break;
            case WINTER:
                System.out.println("Winter is coming!!!");
                break;
            default:
                System.out.println("Booooring midseason!");
                break;
        }
        // result is Winter is coming!

        System.out.println(winter.ordinal());
        // 3
        // WINTER enum order
    }
}