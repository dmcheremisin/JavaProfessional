package $01AdvancedClassDesign.packages;

/**
 * Created by Dmitrii on 20.05.2018.
 */
class A {
    A() {
        print();
    }
    private void print() {
        System.out.println("A");
    }
}
public class PrivateExtendedMethod extends A {
    int i = Math.round(3.5f);

    public static void main(String[] args) {
        A a = new PrivateExtendedMethod();
        // a.print(); -> print has private access
    }
    void print() {
        System.out.println(i);
    }
}
/*
print() is declared private in class A. So a.print() is not valid in class B's code as the class of 'a' is A.
Now, you may think that the actual object is of class B and method to be executed is selected according to the actual object.
While that is true (except in case of private instance methods, which are bound at compile time anyway), access rights are checked at compile time.
At compile time, the compiler has no knowledge of the actual object and so access rights are checked against the class of the variable.
 */
