package $02DesignPatternsAndPrinciples.functionalInterface;

/**
 * Created by Dmitrii on 12.01.2018.
 */
public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sprintAnimal(Sprint sprint){
        sprint.printAction(this);
    }

    public void runAnimal(Run run){
        run.printAction(this);
        run.printName();
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Dog");
        // Sprint interface
        Sprint sprint = a -> System.out.println(a.name + " is running");
        sprint.printAction(animal);
        // OR
        animal.sprintAnimal(a -> System.out.println(a.name + " is walking"));

        // Run interface
        animal.runAnimal(a -> System.out.println(a.name + " is walking"));
    }
}
