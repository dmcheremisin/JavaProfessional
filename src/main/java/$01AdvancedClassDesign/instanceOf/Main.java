package $01AdvancedClassDesign.instanceOf;

/**
 * Created by Dmitrii on 10.01.2018.
 */
interface BigEar {}
class HeavyAnimal {}
class Hippo extends HeavyAnimal {}
class BigEarHippo extends Hippo implements BigEar {}

class Elephant {}

public class Main {
    public static void main(String[] args) {
        HeavyAnimal heavyHippo = new Hippo();

        System.out.println("heavyHippo instanceof Hippo = " + (heavyHippo instanceof Hippo)); // true
        System.out.println("heavyHippo instanceof HeavyAnimal = " + (heavyHippo instanceof HeavyAnimal)); // true

        // System.out.println(heavyHippo instanceof Elephant); doesn't compile
        // because hippo can't be instance of Elephant, compilation check for a class

        Hippo hippo = new Hippo();
        // System.out.println(hippo instanceof Elephant); doesn't compile - the same reason as above

        System.out.println("hippo instanceof BigEar = " + (hippo instanceof BigEar)); // false: compiles as there could be
        // another "class BigEarHippo extends Hippo implements BigEar"

        Hippo bigEarHippo = new BigEarHippo();
        System.out.println("bigEarHippo instanceof BigEar = " + (bigEarHippo instanceof BigEar)); // true

        System.out.println(null instanceof Object); // false
        hippo = null;
        System.out.println(hippo instanceof Object); // false

    }
}
