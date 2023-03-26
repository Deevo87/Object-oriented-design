package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.FoodItem;
import pl.edu.agh.dronka.shop.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class FoodProvider implements Provider{

    private Date expirationDate;

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        try {
            this.expirationDate = new SimpleDateFormat("dd-MM-yyyy").parse(reader.getValue(dataLine, "Data przydatności do spożycia"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new FoodItem(name, category, price, quantity, expirationDate);
    }
}
