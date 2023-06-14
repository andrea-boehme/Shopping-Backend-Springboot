package com.example.shoppingbackendspringboot.enumeration;

public enum Availability {
    AVAILABLE("Available"),
    OUT_OF_STOCK("Out of Stock"),
    LIMITED_STOCK("Limited Stock");

    private final String availability;

    Availability(String availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }
}