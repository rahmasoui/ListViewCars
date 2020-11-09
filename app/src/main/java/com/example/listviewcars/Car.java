package com.example.listviewcars;

public class Car {
    private String name;
    private String price;
    private int iconID;
    public Car(int iconID,String name, String price) {
        this.name = name;
        this.price = price;
        this.iconID = iconID;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
