package pl.edu.agh.dronka.shop.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class EletronicItem extends Item {

    private boolean mobile;

    private boolean guarantee;

    private Map<String, Object> additionalAttributes = new LinkedHashMap<>();

    public EletronicItem(String name, Category category, int price, int quantity, boolean mobile, boolean guarantee) {
        super(name, category, price, quantity);
        this.guarantee = guarantee;
        this.mobile = mobile;
    }

    public boolean getMobile() { return mobile;}

    public boolean getGuarantee() { return guarantee;}

    @Override
    public Map<String, Object> getAdditionalAttributes() {
        this.additionalAttributes.put("Mobilny", this.mobile);
        this.additionalAttributes.put("Gwarancja", this.guarantee);
        return additionalAttributes;
    }
}
