package enums;

import java.util.Arrays;
import java.util.List;

public enum Category {
    CLOTHES("MEN", "WOMEN"),
    ACCESSORIES("STATIONERY", "HOME ACCESSORIES");

    private final List<String> subCategories;

    Category(String... subCategories) {
        this.subCategories = Arrays.asList(subCategories);
    }

    public List<String> getSubCategories() {
        return subCategories;
    }
}