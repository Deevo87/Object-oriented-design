package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;

public class ProviderDistributor {
    public static Provider chooseProvider(Category category) {
        switch(category) {
            case BOOKS -> {
                return new BooksProvider();
            }
            case ELECTRONICS -> {
                return new ElectronicsProvider();
            }
            case FOOD -> {
                return new FoodProvider();
            }
            case MUSIC -> {
                return new MusicProvider();
            }
            case SPORT -> {
                return new SportProvider();
            }
            default -> throw new IllegalArgumentException("Given category does not exist.");
        }
    }
}
