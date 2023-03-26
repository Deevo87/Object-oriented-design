package pl.edu.agh.dronka.shop.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SportItem extends Item{

    private Map<String, Object> additionalAttributes = new LinkedHashMap<>();

    public SportItem(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    @Override
    public Map<String, Object> getAdditionalAttributes() {
        return additionalAttributes;
    }
}
