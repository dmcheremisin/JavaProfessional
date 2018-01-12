package $02DesignPatternsAndPrinciples.functionalInterface;

/**
 * Created by Dmitrii on 12.01.2018.
 */
public interface Run extends Sprint{
    default void printName() {
        System.out.println("My name is Run!");
    }
}
