package instanceOf;

import javax.xml.bind.Element;

/**
 * Created by Dmitrii on 10.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        HeavyAnimal heavyHippo = new Hippo();

        System.out.println("heavyHippo instanceof Hippo = " + (heavyHippo instanceof Hippo));
        System.out.println("heavyHippo instanceof HeavyAnimal = " + (heavyHippo instanceof HeavyAnimal));

        // System.out.println(heavyHippo instanceof Elephant); doesn't compile
        // because hippo can't be instance of Elephant, compilation check for a class

        Hippo hippo = new Hippo();
        // System.out.println(hippo instanceof Elephant); doesn't compile - the same reason as above

        System.out.println("hippo instanceof BigEar = " + (hippo instanceof BigEar)); // compiles as there could be
        // another "class BigEarHippo extends Hippo implements BigEar"

        Hippo bigEarHippo = new BigEarHippo();
        System.out.println("bigEarHippo instanceof BigEar = " + (bigEarHippo instanceof BigEar));

        System.out.println(null instanceof Object); // false
        hippo = null;
        System.out.println(hippo instanceof Object); // false

    }
}
