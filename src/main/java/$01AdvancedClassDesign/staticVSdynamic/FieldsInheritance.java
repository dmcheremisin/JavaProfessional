package $01AdvancedClassDesign.staticVSdynamic;

/**
 * Created by Dmitrii on 09.01.2018.
 */

class Parent {
    public String name = "Parent class";
    public static String sName = "Parent class";

    public String getString() {
        return "Parent class";
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
    public String name = "Child class";
    public static String sName = "Child class";

    public String getString() {
        return "Child class";
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
        // Parent class
        System.out.println(parent.sName);
        // Parent class

        System.out.println(" =============== ");
        System.out.println(parent.getString());
        // Child class
        System.out.println(parent.getName());
        // Child class
        System.out.println(parent.printName());
        // Parent class
        System.out.println(parent.getSName());
        // Child class
        System.out.println(parent.getStatic());
        // Parent class
    }
}
