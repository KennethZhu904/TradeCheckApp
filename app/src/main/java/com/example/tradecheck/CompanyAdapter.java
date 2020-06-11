package com.example.tradecheck;

import android.widget.ArrayAdapter;

public class CompanyAdapter extends ArrayAdapter<Company> {

    public CompanyAdapter(Context context, ArrayList<Company> aCompanies){
        super(context, 0, aCompanies);
    }
}
