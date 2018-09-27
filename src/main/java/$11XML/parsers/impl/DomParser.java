package $11XML.parsers.impl;

import $11XML.parsers.FoodParser;
import $11XML.model.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

import static $11XML.model.Food.*;
import static $11XML.Main.extractPrice;
import static $11XML.Main.getXmlFile;

/**
 * Created by Dmitrii on 17.12.2017.
 */
public class DomParser implements FoodParser {
    @Override
    public List<Food> getFoodList() throws Exception {
        List<Food> data = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(getXmlFile());

        NodeList nodeList = doc.getElementsByTagName(ROOT);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Food food = new Food();
            data.add(food);

            Element item = (Element) nodeList.item(i);
            String id = item.getAttribute(ID);
            food.setId(Integer.parseInt(id));

            food.setName(getElementText(item, NAME));
            food.setDescription(getElementText(item, DESCRIPTION));

            String price = getElementText(item, PRICE);
            food.setPrice(extractPrice(price));

            String calories = getElementText(item, CALORIES);
            food.setCalories(Integer.parseInt(calories));
        }
        return data;
    }

    private String getElementText(Element item, String name) {
        Element elem = (Element) item.getElementsByTagName(name).item(0);
        return elem.getTextContent();
    }
}
