package pl.edu.agh.dronka.shop.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookItem extends Item{

    private int pages;
    private boolean cover;

    private Map<String, Object> additionalAttributes = new LinkedHashMap<>();

    public BookItem(String name, Category category, int price, int quantity, int pages, boolean cover) {
        super(name, category, price, quantity);
        this.cover = cover;
        this.pages = pages;
    }

    public int getPages() { return pages;}

    public boolean getCover() { return cover; }

    @Override
    public Map<String, Object> getAdditionalAttributes() {
        this.additionalAttributes.put("Liczba stron", Integer.toString(this.pages));
        this.additionalAttributes.put("Twarda oprawa", Boolean.toString(this.cover));
        return additionalAttributes;
    }

}
