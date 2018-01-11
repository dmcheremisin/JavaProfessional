package $01AdvancedClassDesign.enums;

import static $01AdvancedClassDesign.enums.WorkingHours.MORNING;

/**
 * Created by Dmitrii on 10.01.2018.
 */

enum WorkingHours {
    MORNING {
        @Override
        public void printHours() {
            System.out.println("07:00 - 12:00");
        }
    }, DINNER {
        @Override
        public void printHours() {
            System.out.println("12:00 - 15:00");
        }
    }, EVENING {
        @Override
        public void printHours() {
            System.out.println("15:00 - 19:00");
        }
    }; // semicolon ; is necessary!

    // abstract method that every enum should implement
    public abstract void printHours();
}

public class AbstractMethod {
    public static void main(String[] args) {
        MORNING.printHours();
        for (WorkingHours workingHours : WorkingHours.values()) {
            System.out.println(workingHours);
            workingHours.printHours();
        }
        /*07:00 - 12:00
        MORNING
        07:00 - 12:00
        DINNER
        12:00 - 15:00
        EVENING
        15:00 - 19:00*/
    }
}
