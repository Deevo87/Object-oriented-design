package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.BookItem;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.List;

public class BooksProvider implements Provider{

    private int pages;

    private boolean cover;

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        this.pages = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
        this.cover = Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"));

        return new BookItem(name, category, price, quantity, pages, cover);
    }
}
