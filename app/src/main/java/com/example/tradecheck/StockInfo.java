package com.example.tradecheck;

import java.io.Serializable;

public class StockInfo implements Serializable {
    private int price;
    private int[] stock_images;

    //Constructor
    public StockInfo(int price, int[] stock_images){
        this.price = price;
        this.stock_images = stock_images;
    }

    // Getter Functions
    public String getPrice(){
        String price = "Price: $" + Integer.toString(this.price) + "/share";
        return price;
    }

    public int[] getStock_images(){
        return this.stock_images;
    }

}
