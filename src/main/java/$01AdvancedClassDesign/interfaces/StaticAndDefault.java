package $01AdvancedClassDesign.interfaces;

/**
 * Created by Dmitrii on 21.05.2018.
 */
interface Home {
    public String getAddress();
}
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
interface HO extends House, Office {}

// compilation error - Error:(21, 1) java: interface $01AdvancedClassDesign.interfaces.HHO inherits abstract and default for getAddress()
//interface HHO extends Home, House, Office {}

// class resolves ambiguous method - so no problem for compilation
class HomeOffice implements Home, House, Office {
    public String getAddress() {
        return "R No 1, Home";
    }
}
public class StaticAndDefault {
    public static void main(String[] args) {
        Office office = new HomeOffice();
        //System.out.println(office.getAddress()); doesn't compile: static method should be called only with interface reference

        System.out.println(Office.getAddress());// static method should be called only with interface reference
        // 101 Smart Str

        House house = (House) office;
        System.out.println(house.getAddress()); // R No 1, Home
        Home home = (Home) office;
        System.out.println(home.getAddress()); // R No 1, Home
    }
}