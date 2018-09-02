package $11XML.parsers.impl;

import $11XML.parsers.FoodParser;
import $11XML.model.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static $11XML.model.Food.*;
import static $11XML.Main.*;

/**
 * Created by Dmitrii on 16.12.2017.
 */
public class SaxParser extends DefaultHandler implements FoodParser {

    private List<Food> foodList = new ArrayList<>();
    private Food food;
    private StringBuilder sb;

    public List<Food> getFoodList() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(getXmlFile(), this);
        return foodList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case BREAKFAST_MENU:
                break;
            case ROOT:
                food = new Food();
                food.setId(Integer.parseInt(attributes.getValue(ID)));
                foodList.add(food);
                break;
            default:
                sb = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (BREAKFAST_MENU.equals(localName) || ROOT.equals(localName)) {
            return;
        }
        String element = sb.toString();
        switch (qName) {
            case NAME:
                food.setName(element);
                break;
            case PRICE:
                food.setPrice(extractPrice(element));
                break;
            case DESCRIPTION:
                food.setDescription(element);
                break;
            case CALORIES:
                food.setCalories(Integer.parseInt(element));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (sb != null) {
            sb.append(ch, start, length);
        }
    }
}
