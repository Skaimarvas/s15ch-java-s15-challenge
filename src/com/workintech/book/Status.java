package com.workintech.book;

public enum Status {
    AVAILABLE("Available in the library"),
    ON_LOAN("Borrowed"),
    NOT_IN_CATALOG("Not available in the library records");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
