package pl.edu.agh.dronka.shop.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class FoodItem extends Item{

    private Date expirationDate;

    private Map<String, Object> additionalAttributes = new LinkedHashMap<>();

    public FoodItem(String name, Category category, int price, int quantity, Date expirationDate) {
        super(name, category, price, quantity);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() { return expirationDate; }

    @Override
    public Map<String, Object> getAdditionalAttributes() {
        this.additionalAttributes.put("Data przydatności do spożycia", this.expirationDate);
        return additionalAttributes;
    }
}
