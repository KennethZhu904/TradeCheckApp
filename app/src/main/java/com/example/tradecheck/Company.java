package com.example.tradecheck;

public class Company {
    private String name;
    private String country;
    private String id;
    private int popularity;
    private String description;
    private int logoAddress;
    private StockInfo stock;

    // Company Constructor
    public Company( String name, String id, String country, int logoAddress, int popularity, String description, StockInfo stock){
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

    public String getId(){
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
