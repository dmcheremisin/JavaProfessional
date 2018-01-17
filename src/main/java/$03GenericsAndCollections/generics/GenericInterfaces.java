package $03GenericsAndCollections.generics;

interface Shippable<T> {
    public void ship(T t);
}
interface ChargableShippable<T, U> extends Shippable<U>{
    void charge(T t);
}
class Robot<T, U> implements ChargableShippable<T,U> {
    @Override
    public void charge(T t) {
        System.out.println("Charging " + t);
    }
    @Override
    public void ship(U u) {
        System.out.println("Shipping " + u + " kg");
    }
}
class Car implements ChargableShippable<String, String>{
    @Override
    public void ship(String s) {
        System.out.println("Shipping " + s);
    }
    @Override
    public void charge(String s) {
        System.out.println("Charging " + s);
    }
}
class Helicopter implements ChargableShippable{
    @Override
    public void ship(Object o) {
        System.out.println(o);
    }
    @Override
    public void charge(Object o) {
        System.out.println(o);
    }
}

public class GenericInterfaces {
    public static void main(String[] args) {
        Robot<String, Integer> robot = new Robot<>();
        robot.charge("New Alpha 2.0");
        robot.ship(20);

        Car car = new Car();
        car.ship("Lambordgini Diablo");
        car.charge("50 litres");

        Helicopter helicopter = new Helicopter();
        helicopter.charge("Acula");
        helicopter.ship("To Vladivostok");
    }
}
