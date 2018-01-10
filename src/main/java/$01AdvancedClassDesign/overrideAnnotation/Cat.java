package $01AdvancedClassDesign.overrideAnnotation;

/**
 * Created by Dmitrii on 10.01.2018.
 */
public class Cat {
    public void findMeat() {}
}
class Lion extends Cat{
    @Override // Compiles normally because signatures matches
    public void findMeat() {}
}
class HomeCat extends Cat {
    // @Override signatures doesn't match - method is overloaded, not overriden
    // So, doesn't compile with @Override signature
    public void findMeat(boolean b) {}
}
