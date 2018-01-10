package accessModifier.cat.species;

import accessModifier.cat.BigCat;

/**
 * Created by Dmitrii on 10.01.2018.
 */
public class Lynx extends BigCat {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        // Doesn't compile:
        // System.out.println(cat.hasFur); <- protected access modifier
        // System.out.println(cat.hasPaws); <- package-private access modifier
        // System.out.println(cat.id); <- private access modifier
    }
}
