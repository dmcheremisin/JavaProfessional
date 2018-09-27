package $11XML.parsers.impl;

import $11XML.parsers.FoodParser;
import $11XML.model.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static $11XML.model.Food.*;
import static $11XML.Main.extractPrice;
import static $11XML.Main.getXmlFile;

/**
 * Created by Dmitrii on 17.12.2017.
 */
public class StAXParser implements FoodParser {
    @Override
    public List<Food> getFoodList() throws Exception {
        List<Food> data = new ArrayList<>();
        Food food = null;

        FileInputStream stream = new FileInputStream(getXmlFile());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(stream);

        while (reader.hasNext()) {
            int eventType = reader.next();
            if (XMLEvent.START_ELEMENT == eventType) {
                String eventName = reader.getName().toString();
                switch (eventName) {
                    case ROOT:
                        data.add(food = new Food());
                        food.setId(Integer.parseInt(reader.getAttributeValue("", Food.ID)));
                        break;
                    case NAME:
                        food.setName(reader.getElementText());
                        break;
                    case PRICE:
                        BigDecimal price = extractPrice(reader.getElementText());
                        food.setPrice(price);
                        break;
                    case DESCRIPTION:
                        food.setDescription(reader.getElementText());
                        break;
                    case CALORIES:
                        food.setCalories(Integer.parseInt(reader.getElementText()));
                        break;
                }
            }
        }

        return data;
    }
}
