package $02DesignPatternsAndPrinciples.immutableObjectPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Animal {
    private final String name;
    private final int age;
    private final List<String> food;

    public Animal(String name, int age, List<String> food) {
        this.name = name;
        this.age = age;
        if (food == null) {
            throw new RuntimeException("Food can't be empty!");
        }
        this.food = new ArrayList<>(food);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFood(int index){
        return food.get(index);
    }

    public int getFoodCount(){
        return food.size();
    }

    public static void main(String[] args) {
        Animal animal = new Animal("lion", 5, Arrays.asList("zebra", "giraffe", "bull"));
        int foodCount = animal.getFoodCount();
        System.out.println("Food count: " + foodCount);
        for(int i = 0; i < foodCount; i++) {
            System.out.println(animal.getFood(i));
        }
    }
}
