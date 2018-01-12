package $02DesignPatternsAndPrinciples.objectComposition;

/**
 * Created by Dmitrii on 12.01.2018.
 */
class Flippers {
    public void flap(){
        System.out.println("Flippers flap!");
    }
}

class WebbedFeet {
    public void kick() {
        System.out.println("Webbed feet kick!");
    }
}

public class Penguine {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguine() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }

    public void kick() {
        this.webbedFeet.kick();
    }

    public static void main(String[] args) {
        Penguine penguine = new Penguine();
        penguine.flap();
        penguine.kick();
    }
}
