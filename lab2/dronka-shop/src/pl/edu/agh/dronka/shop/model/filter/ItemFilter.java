package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private FilterSetter itemSpec = new FilterSetter();

	public FilterSetter getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		switch (itemSpec.getCategory()) {
			case BOOKS -> {
				Boolean hardCover = Boolean.parseBoolean(String.valueOf(item.getAdditionalAttributes().get("Twarda oprawa")));

				if (itemSpec.isHardCover() && !hardCover) {
					return false;
				}
			}
			case ELECTRONICS -> {
				Boolean isMobile = Boolean.parseBoolean(String.valueOf(item.getAdditionalAttributes().get("Mobilny")));

				if (itemSpec.isMobile() && !isMobile) {
					return false;
				}

				Boolean isGuarantee = Boolean.parseBoolean(String.valueOf(item.getAdditionalAttributes().get("Mobilny")));

				if (itemSpec.isGuarantee() && isGuarantee) {
					return false;
				}
			}
			case MUSIC -> {
				Boolean isVideo = Boolean.parseBoolean(String.valueOf(item.getAdditionalAttributes().get("Video")));

				if (itemSpec.isVideo() && !isVideo) {
					return false;
				}
			}
		}




		return true;
	}

}