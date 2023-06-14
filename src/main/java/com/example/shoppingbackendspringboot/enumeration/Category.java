package com.example.shoppingbackendspringboot.enumeration;

public enum Category {
    BOOKS("Books"),
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
