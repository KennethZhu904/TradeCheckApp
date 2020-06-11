package com.example.tradecheck;

import java.io.Serializable;

public class Company implements Serializable {
    private String name;
    private String country;
    private String id;
    private int popularity;
    private String description;
    private int logoAddress;

    public Company( String name, String id, String country, int logoAddress, int popularity, String description){
        this.id = id;
        this.country = country;
        this.name = name;
        this.logoAddress = logoAddress;
        this.popularity = popularity;
        this.description = description;
    }

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
}
