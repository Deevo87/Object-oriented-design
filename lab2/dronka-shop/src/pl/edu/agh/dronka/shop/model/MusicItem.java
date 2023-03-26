package pl.edu.agh.dronka.shop.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MusicItem extends Item{

    private MusicGenre genre;

    private boolean isVideo;

    private Map<String, Object> additionalAttributes = new LinkedHashMap<>();

    public MusicItem(String name, Category category, int price, int quantity, MusicGenre genre, boolean isVideo) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.isVideo = isVideo;
    }

    public MusicGenre getGenre() { return genre; }

    public boolean getIsVideo() { return isVideo; }

    @Override
    public Map<String, Object> getAdditionalAttributes() {
        this.additionalAttributes.put("Gatunek muzyczny", this.genre);
        this.additionalAttributes.put("Video", this.isVideo);
        return additionalAttributes;
    }
}
