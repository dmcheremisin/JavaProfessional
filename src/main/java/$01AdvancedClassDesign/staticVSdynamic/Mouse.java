package $01AdvancedClassDesign.staticVSdynamic;

/**
 * Created by Dmitrii on 02.03.2019.
 */
class Rodent {
    static int height = 5;
    int length = 6;
    void getHeight() {
        System.out.println("parent height = " + height);
    }
    void getLength() {
        System.out.println("parent length = " + length);
    }
}
public class Mouse extends Rodent {
    static int height = 10;
    int length = 12;

    void getMouseHeight() {
        System.out.println("height = " + height + ", parent height = " + super.height);
    }
    void getMouseLength() {
        System.out.println("length = " + length + ", parent length = " + super.length);
    }
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.getHeight();
        mouse.getLength();
        System.out.println("---------------");
        mouse.getMouseHeight();
        mouse.getMouseLength();
    }
    //parent height = 5
    //parent length = 6
    //---------------
    //height = 10, parent height = 5
    //length = 12, parent length = 6
}
