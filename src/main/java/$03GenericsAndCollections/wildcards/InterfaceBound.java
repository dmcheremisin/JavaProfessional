package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
interface Flyer{}
class Squirrel implements Flyer{}
class Goose implements Flyer{}

public class InterfaceBound {
    public static void main(String[] args) {
        List<Flyer> flyer = new ArrayList<>();
        List<Squirrel> squirrels = new ArrayList<>();
        anyFlyer(flyer);
        // anyFlyer(squirrels); not possible as types are different

        groupOfFlyers(flyer);
        groupOfFlyers(squirrels); // everything is OK
    }

    public static void anyFlyer(List<Flyer> list) {
        list.add(new Flyer(){});
        list.add(new Squirrel());
        list.add(new Goose());
    }
    public static void groupOfFlyers(List<? extends Flyer> list) {
//      nothing is working
//      list.add(new Flyer(){});
//      list.add(new Squirrel());
//      list.add(new Goose());
    }
}
