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
        System.out.println(parent.sName);
        // A class
        // A class
        System.out.println(" =============== ");
        System.out.println(parent.getString());
        System.out.println(parent.getName());
        System.out.println(parent.getSName());
        System.out.println(parent.getStatic());
        // B class
        // B class
        // B class
        // A class
    }
}
