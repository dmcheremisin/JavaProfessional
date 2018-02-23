package $06ExceptionsAndAssertions.assertions;

import static $06ExceptionsAndAssertions.assertions.Season.WINTER;

/**
 * Created by Dmitrii on 24.02.2018.
 */
enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class ControlFlowInvariant {
    public static void main(String[] args) {
        Season winter = WINTER;
        switch (winter) {
            case SPRING:
            case FALL:
                System.out.println("Short hours");
                break;
            case SUMMER:
                System.out.println("Long hours");
                break;
            default:
                assert false : "Invalid season";
        }
    }
}
