package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.MusicGenre;
import pl.edu.agh.dronka.shop.model.MusicItem;

public class MusicProvider implements Provider{

    private MusicGenre genre;

    private boolean isVideo;
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        this.genre = MusicGenre.valueOf(reader.getValue(dataLine, "Gatunek muzyczny"));
        this.isVideo = Boolean.parseBoolean(reader.getValue(dataLine, "Video"));
        return new MusicItem(name, category, price, quantity, genre, isVideo);
    }
}
