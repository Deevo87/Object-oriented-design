package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.EletronicItem;
import pl.edu.agh.dronka.shop.model.Item;

public class ElectronicsProvider implements Provider{

    private boolean mobile;

    private boolean guarantee;
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        this.mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
        this.guarantee = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
        return new EletronicItem(name , category, price, quantity, mobile, guarantee);
    }
}
