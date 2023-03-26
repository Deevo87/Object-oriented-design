package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.Map;

public class FilterSetter{

    private String name;

    private Category category;

    private boolean cover;

    private boolean secondhand;

    private boolean polish;

    private boolean mobile;

    private boolean guarantee;

    private boolean video;

    public FilterSetter() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setSecondhand(boolean secondhand) {
        this.secondhand = secondhand;
    }

    public boolean isSecondhand() {
        return secondhand;
    }

    public void setPolish(boolean polish) {
        this.polish = polish;
    }

    public boolean isPolish() {
        return polish;
    }

    public void setCover(boolean cover) { this.cover = cover; }

    public boolean isHardCover() { return cover; }

    public void setMobile(boolean mobile) { this.mobile = mobile; }

    public boolean isMobile() { return mobile; }

    public void setGuarantee(boolean guarantee) { this.guarantee = guarantee; }

    public boolean isGuarantee() { return guarantee; }

    public void setVideo(boolean video) { this.video = video; }

    public boolean isVideo() { return video; }
}
