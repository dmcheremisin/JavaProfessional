package $01AdvancedClassDesign.interfaces;

/**
 * Created by Dmitrii on 21.05.2018.
 */
interface House {
    public default String getAddress() {
        return "101 Main Str";
    }
}
interface Office {
    public static String getAddress() {
        return "101 Smart Str";
    }
}
// no problem that one interface has static method and another default
interface WFH extends House, Office {}

class HomeOffice implements House, Office {
    public String getAddress() {
        return "R No 1, Home";
    }
}
public class StaticAndDefault {
    public static void main(String[] args) {
        Office off = new HomeOffice();
        System.out.println(Office.getAddress());// static method should be called only with interface reference
        // 101 Smart Str
    }
}