package $02DesignPatternsAndPrinciples.factoryPattern;

public abstract class Food {
    int quantity;
    Food(int quantity) {
        this.quantity = quantity;
    }

    abstract void consumed();
}

class Hay extends Food{
    Hay(int quantity) {
        super(quantity);
    }

    @Override
    void consumed() {
        System.out.println("Hay consumed: " + quantity);
    }
}

class Fish extends Food {
    Fish(int quantity) {
        super(quantity);
    }

    @Override
    void consumed() {
        System.out.println("Fish consumed: " + quantity);
    }
}