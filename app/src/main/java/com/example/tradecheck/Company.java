package com.example.tradecheck;

import java.io.Serializable;

public class Company implements Serializable {
    private String name;
    private String country;
    private int id;
    private int popularity;
    private String description;
    private int logoAddress;
    private StockInfo stock;

    // Company Constructor
    public Company( String name, int id, String country, int logoAddress, int popularity, String description, StockInfo stock){
        this.id = id;
        this.country = country;
        this.name = name;
        this.logoAddress = logoAddress;
        this.popularity = popularity;
        this.description = description;
        this.stock = stock;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public String getCountry(){
        return country;
    }

    public int getId(){
        return id;
    }

    public int getPopularity(){
        return popularity;
    }

    public String getDescription(){
        return description;
    }

    public int getLogo(){
        return logoAddress;
    }

    public StockInfo getStock(){
        return this.stock;
    }
}
