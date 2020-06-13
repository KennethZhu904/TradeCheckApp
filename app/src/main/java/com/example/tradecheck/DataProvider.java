package com.example.tradecheck;

import java.util.ArrayList;

public class DataProvider {
    // A Class that would simulate a data fetching operation

    // Company Names and IDs [ID match array index]
    static String[] companyNames = {"Microsoft", "Countdown", "Singtel", "PWC", "Spark NZ", "Fonterra", "HoneyWell", "Qantas","Singapore Airlines", "FoodStuffs"};
    static int[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Each Companies Respective Price and Description. [Index Match ID]
    static int[] price = {-127, 4, 59, -11, -8,	14,	14,	51, 82, 11};
    static String[] description= {"Microsoft", "Countdown", "Singtel", "PWC", "Spark NZ", "Fonterra", "HoneyWell", "Qantas","Singapore Airlines", "FoodStuffs"};

    // Company Popularity [Initially Zero, Increases every click]
    static int[] popularity = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // The Apps Four Categories. The Country name and respective flag.
    static String[] countryNames = { "Australia", "New Zealand", "Singapore", "United States"};
    static int[] countryFlags = {R.drawable.au, R.drawable.nz, R.drawable.sg, R.drawable.us};

    // The Respective Company IDs for each section
    static int[] AustraliaId={1, 6, 7};
    static int[] NZId={3, 4, 5, 9};
    static int[] SingaporeId={2, 8};
    static int[] USId={0};

    // --------------------------------------------------------------------------------------------
    // Generate StockData Given a ID Number
    public static StockInfo generateStockInfo(int id){
       int cost = price[id];
       int[] graphLocation = {R.drawable.day, R.drawable.month, R.drawable.year};

       return new StockInfo(cost, graphLocation);
    }

    // Generate A Company Object Given a ID Number
    public static Company generateCompany(int id){
        int logo = R.drawable.us;
        StockInfo stock = generateStockInfo(id);

        return new Company(companyNames[id], id, "Temp Country", logo, popularity[id], description[id], stock );
    }

    // Generate Companies Given ID Numbers
    public static ArrayList<Company> generateCompanies(int[] idList){
        ArrayList<Company> listOfCompanies = new ArrayList<Company>();

        // Add a company for each id
        for (int i = 0; i < idList.length; i++) {
            Company aCompany = generateCompany(idList[i]);
            listOfCompanies.add(aCompany);
        }

        return listOfCompanies;
    }

    // Return the IDs of the top three popular companies
    public static int[] topCompanies(){
        // Initialise Three IDs
        int top1 = 0;
        int top2 = 0;
        int top3 = 0;

        // Go through popularity list and retrieve most popular
        for (int i = 1; i < popularity.length; i++){
            // Sort and change relevant order
            if (popularity[top1] <= popularity[i]){
                top3 = top2;
                top2 = top1;
                top1 = i;
            }
            else if(popularity[top2] <= popularity[i]){
                top3 = top2;
                top2 = i;
            }
            else if(popularity[top3] <= popularity[i]){
                top3 = i;
            }
        }

        // Place variables in list format
        int[] topThree = {top1, top2, top3};
        return topThree;
    }

    // Return ID of companies whose names are in search
    public static int[] searchCompanies(String search){
        // Initialise Search list
        int foundSearches = 0;
        int[] searchIDs = new int[ids.length];

        //If part of name then add company to list
        for (int i = 0; i < ids.length; i++) {
            if (companyNames[i].contains(search)) {
                searchIDs[i] = 1;
                foundSearches = foundSearches + 1;
            } else {
                searchIDs[i] = 0;
            }
        }

        //Initialised the matching company list
        int[] companies = new int[foundSearches];
        int j = 0; // A Temporary array iterator

        // If the company was matching add to the list
        for (int i = 0; i < ids.length; i++) {
            if (searchIDs[i] == 1) {
                companies[j] = ids[i];
                j = j + 1;
            }
        }

        return companies;
    }


    public static int[] getCompanyIDs(String country) {
        int[] companyIDs = AustraliaId;

        if (country.equals("NZ"))
            companyIDs = NZId;
        else if (country.equals("Singapore"))
            companyIDs = SingaporeId;
        else if (country.equals("United States"))
            companyIDs = USId;

        return companyIDs;
    }

    public static String[] getCountryNames() {
        return countryNames;
    }

//    public static ArrayList<Countries> generateData() {
//        ArrayList<Countries> listOfCountries = new ArrayList<Countries>();
//
//
//        for (int i = 0; i < 4; i++) {
//
//            String id = ids[i];
//            String countriesname = countryNames[i];
//            int flags = countryFlags[i];
//            Countries aCountry = new Countries(countriesname, flags, id);
//            listOfCountries.add(aCountry);
//        }
//        return listOfCountries;
//    }

}
