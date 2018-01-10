package staticVSdynamic;

/**
 * Created by Dmitrii on 09.01.2018.
 */

class Parent {
    public String name = "A class";
    public static String sName = "A class";

    public String getString() {
        return "A class";
    }
    public String getName() {
        return name;
    }
    public String printName() {
        return name;
    }
    public String getSName() {
        return sName;
    }
    public static String getStatic() {
        return sName;
    }
}

class Child extends Parent {
    public String name = "B class";
    public static String sName = "B class";

    public String getString() {
        return "B class";
    }
    public String getName() {
        return name;
    }
    public String getSName() {
        return sName;
    }
    public static String getStatic() {
        return sName;
    }
}

public class FieldsInheritance {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.name);
        // A class
        System.out.println(parent.sName);
        // A class

        System.out.println(" =============== ");
        System.out.println(parent.getString());
        // B class
        System.out.println(parent.getName());
        // B class
        System.out.println(parent.printName());
        // A class
        System.out.println(parent.getSName());
        // B class
        System.out.println(parent.getStatic());
        // A class
    }
}
