package $01AdvancedClassDesign.staticVSdynamic;

/**
 * Created by Dmitrii on 09.01.2018.
 */

class Parent {
    public String name = "Parent";
    public static String sName = "Parent";

    public String getString() {
        return "Parent";
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
    public String name = "Child";
    public static String sName = "Child";

    public String getString() {
        return "Child";
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
        // Parent
        System.out.println(parent.sName);
        // Parent

        System.out.println(" =============== ");
        System.out.println(parent.getString());
        // Child
        System.out.println(parent.getName());
        // Child
        System.out.println(parent.printName());
        // Parent
        System.out.println(parent.getSName());
        // Child
        System.out.println(parent.getStatic());
        // Parent
    }
}
