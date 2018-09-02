package $11XML;

import $11XML.model.Food;
import $11XML.parsers.FoodParser;
import $11XML.parsers.impl.DomParser;
import $11XML.parsers.impl.SaxParser;
import $11XML.parsers.impl.StAXParser;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitrii on 16.12.2017.
 */
public class Main {

    public static final String pricePattern = "\\$(.*)";

    public static void main(String[] args) throws Exception {
        //FoodParser parser = new SaxParser();
        //FoodParser parser = new StAXParser();
        FoodParser parser = new DomParser();
        List<Food> foodList = parser.getFoodList();
        if(foodList != null && !foodList.isEmpty()) {
            for (Food food : foodList) {
                System.out.println(food);
            }
        }
    }

    public static File getXmlFile() {
        Object object = new Main();
        String fileName = object.getClass().getClassLoader().getResource("xml.xml").getFile();
        return new File(fileName);
    }

    public static BigDecimal extractPrice(String str) {
        String match = "";
        Pattern p = Pattern.compile(pricePattern);
        Matcher matcher = p.matcher(str);
        if(matcher.matches()) {
            match = matcher.group(1);
        }
        return new BigDecimal(match);
    }
}
