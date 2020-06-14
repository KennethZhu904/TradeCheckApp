package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class Company_Details extends AppCompatActivity {

    ImageView ivLogo;
    TextView tvName;
    TextView tvPrice;
    TextView tvDetails;

    ViewPager vpStocks;
    SwipeAdaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__details);

        //Assign Layout ID values
        ivLogo = findViewById (R.id.companyLogo);
        tvName = findViewById(R.id.companyName);
        tvPrice = findViewById(R.id.companyPrice);
        tvDetails = findViewById(R.id.companyDescription);
        vpStocks = (ViewPager)findViewById(R.id.stockData);

        // Use the company to populate the data into the format
        Intent thisIntent = getIntent();

        //Company company = (Company) thisIntent.getSerializableExtra(MainActivity.COMPANY_DETAIL_KEY);
        Company company = DataProvider.generateCompany(1);

        adaptor = new SwipeAdaptor(this, company.getStock().getStock_images());
        vpStocks.setAdapter(adaptor);

        loadCompany(company);
    }

    //The Load Company Function
    private void loadCompany(Company company) {

        //Set activity title
        this.setTitle(company.getName());

        // Set the text values
        tvName.setText(company.getName());
        tvDetails.setText(company.getDescription());

        // Set company logo
        ivLogo.setImageResource(company.getLogo());

        // Get stock data
        StockInfo stock = company.getStock();

        // Set Stock Text Values
        //String price = Integer.toString(stock.getPrice());
        tvPrice.setText(stock.getPrice());
    }
}