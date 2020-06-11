package com.example.tradecheck;

import java.util.ArrayList;

public class CompanyProvider {


   // static String[] companyNames= {"Microsoft, PWC, Spark NZ, Fonterra, HoneyWell, Qantas,Singapore Airlines "};
    static String[] ids= {"001","002","003","004"};
    static String[] countries={ "Australia","NZ", "Singapore","United States"};
    static int[] pictures={R.drawable.AU,R.drawable.NZ,R.drawable.SG,R.drawable.US};


    public static String[] getCountries() {
        return countries;
    }

    public static ArrayList<Countries> generateData() {
        ArrayList<Countries> listOfCountries = new ArrayList<Countries>();


        for (int i = 0; i < 4; i++) {

            String id = ids[i];
            String countriesname = countries[i];
            int flags = pictures[i];
            Countries aCountry = new Countries(countriesname, flags, id);
            listOfCountries.add(aCountry);
        }
        return listOfCountries;
    }

}
