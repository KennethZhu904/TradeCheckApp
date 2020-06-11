package com.example.tradecheck;

public class Countries {

    String names;
    int flagFileName;
    String id;

    public String getName(){
        return names;
    }


    public int  getFlagFileName(){

        return flagFileName;
    }

    public String getId(){
        return id;
    }


    public Countries(String names, int flagFileName, String id){

        this.names=names;
        this.flagFileName=flagFileName;
        this.id=id;

    }

}
