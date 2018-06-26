package $01AdvancedClassDesign.common;

/**
 * Created by Dmitrii on 26.06.2018.
 */
class Book {
    protected final int pages = 100;
    final void mA() {
        System.out.println("In B.mA " + pages);
    }
}

class Encyclopedia extends Book {
    private int pages = 200; //1
    void mB() {
        System.out.println("In E.mB " + pages);
    }
//    void mA() { <- method is final and can't be overriden
//        System.out.println("In E.mA " + pages);
//    }
}

public class DifferentProblems {
    public static void main(String[] args) {
        Book o1 = new Encyclopedia(); //3
        Encyclopedia encyclopedia = new Encyclopedia();
        // encyclopedia.pages; pages have private access modifier
        Book o2 = new Book();
        o1.mA(); //4
        // o1.mB(); there is no method mB() in the Book class
        o2.mA();
    }
}