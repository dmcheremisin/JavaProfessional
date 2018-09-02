package $11XML.parsers;

import $11XML.model.Food;

import java.util.List;

/**
 * Created by Dmitrii on 17.12.2017.
 */
public interface FoodParser {
    List<Food> getFoodList() throws  Exception;
}
