package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Company_Details extends AppCompatActivity {
    private ImageView logo;
    private TextView name;
    private TextView country;

    //Event Handler for the details
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__details);

        //Relate the qidgits with data
        this.logo = (ImageView) findViewById(R.id.logo);
        this.name = (TextView) findViewById(R.id.name);
        this.country = (TextView) findViewById(R.id.country);

        // Get the intent of the specific company
        Intent thisIntent = getIntent();
        Company company = (Company)thisIntent.getSerializableExtra(MainActivity.COMPANY_DETAIL_KEY);

        // Load Data
        loadCompany(company);

    }

    private void loadCompany(Company company) {
        // Get the name and country data
        name.setText(company.getName());
        country.setText(company.getCountry());
        // Get the logo image address
        int resID = company.getLogo();
        logo.setImageResource(resID);
    }
}