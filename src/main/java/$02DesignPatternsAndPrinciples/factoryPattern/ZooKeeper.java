package $02DesignPatternsAndPrinciples.factoryPattern;

public class ZooKeeper {
    public static void main(String[] args) {
        Food food = FoodFactory.getFood("horse");
        food.consumed();
    }
}
