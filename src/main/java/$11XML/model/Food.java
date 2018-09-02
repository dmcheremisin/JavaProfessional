package $11XML.model;

import java.math.BigDecimal;

/**
 * Created by Dmitrii on 16.12.2017.
 */
public class Food {

    public static final String BREAKFAST_MENU = "breakfast-menu";
    public static final String ROOT = "food";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
    public static final String CALORIES = "calories";

    private int id;
    private String name;
    private BigDecimal price;
    private String description;
    private int calories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }

    /*        <food id="1">
    <name>Belgian Waffles</name>
        <price>$5.95</price>
        <description>
    two of our famous Belgian Waffles with plenty of real maple syrup
        </description>
        <calories>650</calories>
    </food>*/


}
