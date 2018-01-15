package $02DesignPatternsAndPrinciples.builderPattern;

import $02DesignPatternsAndPrinciples.immutableObjectPattern.Animal;
import java.util.Arrays;
import java.util.List;

public class AnimalBuilder {
    private String name;
    private int age;
    private List<String> food;

    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setFood(List<String> food) {
        this.food = food;
        return this;
    }

    public Animal build() {
        return new Animal(name, age, food);
    }

    public static void main(String[] args) {
        Animal tiger = new AnimalBuilder()
                .setAge(5)
                .setName("Tiger")
                .setFood(Arrays.asList("pig", "gazelle"))
                .build();
        System.out.println(tiger.getFoodCount());
    }
}
