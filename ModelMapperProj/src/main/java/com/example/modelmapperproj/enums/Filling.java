package com.example.modelmapperproj.enums;

public enum Filling {

    CHOCOLATE(0, "Chocolate"),
    CHERRY(1, "Cherry"),
    RASPBERRY(5, "Raspberry");

    private Integer id;
    private String type;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    Filling(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

}
