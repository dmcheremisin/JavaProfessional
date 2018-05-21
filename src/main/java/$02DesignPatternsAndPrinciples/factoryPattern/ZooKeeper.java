package $02DesignPatternsAndPrinciples.factoryPattern;

class FoodFactory {

    public static Food getFood(String animalName) {
        switch (animalName) {
            case "horse":
                return new Hay(10);
            case "bear":
                return new Fish(15);
            case "gazelle":
                return new Hay(7);
        }
        throw new UnsupportedOperationException("No animal match foound!");
    }
}

public class ZooKeeper {
    public static void main(String[] args) {
        Food food = FoodFactory.getFood("horse");
        food.consumed();
    }
}
