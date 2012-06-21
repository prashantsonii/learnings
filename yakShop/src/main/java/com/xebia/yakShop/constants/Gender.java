package com.xebia.yakShop.constants;

/**
 * Defines the Gender
 */
public enum Gender {
    M("male"), F("female");

    private String name;

    private Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
