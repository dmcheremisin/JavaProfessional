package accessModifier.cat;

/**
 * Created by Dmitrii on 10.01.2018.
 */
public class CatAdmire {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        System.out.println(cat.hasFur);
        System.out.println(cat.hasPaws);
        // System.out.println(cat.id); <-- private access modifier
    }
}
