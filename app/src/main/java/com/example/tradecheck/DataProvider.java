package com.example.tradecheck;

import android.content.res.Resources;
import android.location.Address;

import java.util.ArrayList;

public class DataProvider {
    // A Class that would simulate a data fetching operation

    // Company Names and IDs [ID match array index]
    static String[] companyNames = {"Microsoft", "Countdown", "Singtel", "PWC", "Spark NZ", "Fonterra", "HoneyWell", "Qantas","Singapore Airlines", "FoodStuffs", "Air NZ"};
    static int[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Each Companies Respective Price and Description. [Index Match ID]
    static int[] price = {-127, 4, 59, -11, 30,	14,	14,	51, 82, 11};
    static String[] description= {"Microsoft", "Countdown", "Singtel", "PWC", "Spark NZ", "Fonterra", "HoneyWell", "Qantas","Singapore Airlines", "FoodStuffs"};

    // Company Popularity [Initially Zero, Increases every click]
    static int[] popularity = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // The Apps Four Categories. The Country name and respective flag.
    static String[] countryNames = { "Australia", "New Zealand", "Singapore", "United States"};
    static int[] countryFlags = {R.drawable.au, R.drawable.nz, R.drawable.sg, R.drawable.us};

    // Create the drawable file data lists
    static int[] logoAdresses = {R.drawable.logo_000, R.drawable.logo_001, R.drawable.logo_002, R.drawable.logo_003, R.drawable.logo_004, R.drawable.logo_005,
            R.drawable.logo_006, R.drawable.logo_007, R.drawable.logo_008, R.drawable.logo_009, R.drawable.logo_010};// R.drawable.logo_011, R.drawable.logo_012,
//            R.drawable.logo_013, R.drawable.logo_014, R.drawable.logo_015, R.drawable.logo_016, R.drawable.logo_017, R.drawable.logo_018, R.drawable.logo_019,
//            R.drawable.logo_020, R.drawable.logo_021, R.drawable.logo_022, R.drawable.logo_023, R.drawable.logo_024, R.drawable.logo_025, R.drawable.logo_026,
//            R.drawable.logo_027, R.drawable.logo_028, R.drawable.logo_029, R.drawable.logo_030, R.drawable.logo_031, R.drawable.logo_032, R.drawable.logo_033,
//            R.drawable.logo_034, R.drawable.logo_035, R.drawable.logo_036, R.drawable.logo_0037, R.drawable.logo_038, R.drawable.logo_039, R.drawable.logo_040};

    static int[] dayAdresses = {R.drawable.day_000, R.drawable.day_001, R.drawable.day_002, R.drawable.day_003, R.drawable.day_004, R.drawable.day_005,
            R.drawable.day_006, R.drawable.day_007, R.drawable.day_008, R.drawable.day_009, R.drawable.day_010, R.drawable.day_011, R.drawable.day_012};
//            R.drawable.day_013, R.drawable.day_014, R.drawable.day_015, R.drawable.day_016, R.drawable.day_017, R.drawable.day_018, R.drawable.day_019,
//            R.drawable.day_020, R.drawable.day_021, R.drawable.day_022, R.drawable.day_023, R.drawable.day_024, R.drawable.day_025, R.drawable.day_026,
//            R.drawable.day_027, R.drawable.day_028, R.drawable.day_029, R.drawable.day_030, R.drawable.day_031, R.drawable.day_032, R.drawable.day_033,
//            R.drawable.day_034, R.drawable.day_035, R.drawable.day_036, R.drawable.day_0037, R.drawable.day_038, R.drawable.day_039, R.drawable.da_040};

    static int[] monthAdresses = {R.drawable.month_000, R.drawable.month_001, R.drawable.month_002, R.drawable.month_003, R.drawable.month_004, R.drawable.month_005,
            R.drawable.month_006, R.drawable.month_007, R.drawable.month_008, R.drawable.month_009, R.drawable.month_010, R.drawable.month_011, R.drawable.month_012};
//            R.drawable.month_013, R.drawable.month_014, R.drawable.month_015, R.drawable.month_016, R.drawable.month_017, R.drawable.month_018, R.drawable.month_019,
//            R.drawable.month_020, R.drawable.month_021, R.drawable.month_022, R.drawable.month_023, R.drawable.month_024, R.drawable.month_025, R.drawable.month_026,
//            R.drawable.month_027, R.drawable.month_028, R.drawable.month_029, R.drawable.month_030, R.drawable.month_031, R.drawable.month_032, R.drawable.month_033,
//            R.drawable.month_034, R.drawable.month_035, R.drawable.month_036, R.drawable.month_0037, R.drawable.month_038, R.drawable.month_039, R.drawable.month_040};

    static int[] yearAdresses = {R.drawable.years_000, R.drawable.years_001, R.drawable.years_002, R.drawable.years_003, R.drawable.years_004, R.drawable.years_005,
            R.drawable.years_006, R.drawable.years_007, R.drawable.years_008, R.drawable.years_009, R.drawable.years_010, R.drawable.years_011, R.drawable.years_012};
//            R.drawable.years_013, R.drawable.years_014, R.drawable.years_015, R.drawable.years_016, R.drawable.years_017, R.drawable.years_018, R.drawable.years_019,
//            R.drawable.years_020, R.drawable.years_021, R.drawable.years_022, R.drawable.years_023, R.drawable.years_024, R.drawable.years_025, R.drawable.years_026,
//            R.drawable.years_027, R.drawable.years_028, R.drawable.years_029, R.drawable.years_030, R.drawable.years_031, R.drawable.years_032, R.drawable.years_033,
//            R.drawable.years_034, R.drawable.years_035, R.drawable.years_036, R.drawable.years_0037, R.drawable.years_038, R.drawable.years_039, R.drawable.years_040};

    // The Respective Company IDs for each section
    static int[] AustraliaId={1, 6, 7};
    static int[] NZId={3, 4, 5, 9};
    static int[] SingaporeId={2, 8};
    static int[] USId={0};

    // --------------------------------------------------------------------------------------------
    // Generate StockData Given a ID Number
    public static StockInfo generateStockInfo(int id){
       int cost = price[id];
       int[] graphLocation = {dayAdresses[id], monthAdresses[id], yearAdresses[id]};

       return new StockInfo(cost, graphLocation);
    }

    // Generate A Company Object Given a ID Number
    public static Company generateCompany(int id){
//        String address = "R.drawable.logo_00" + Integer.toString(id); // Figure a way to implement this to a
//        int adress = Integer.parseInt(address);

        int logo = logoAdresses[id];

        StockInfo stock = generateStockInfo(id);

        //Generate a generic description for each company
        String description = companyNames[id] + " is a successful business whose stock are available on the market. This has been an interesting year for " + companyNames[id]
                + "their stock is available for the " + stock.getPrice();

        return new Company(companyNames[id], id, "Temp Country", logo, popularity[id], description, stock );
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
    public static int[] searchCompanies(String search)
    {
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

    public static ArrayList<Countries> generateData() {
        ArrayList<Countries> listOfCountries = new ArrayList<Countries>();


        for (int i = 0; i < 4; i++) {

            String id = Integer.toString(ids[i]);
            String countriesname = countryNames[i];
            int flags = countryFlags[i];
            Countries aCountry = new Countries(countriesname, flags, id);
            listOfCountries.add(aCountry);
        }
        return listOfCountries;
    }

}
