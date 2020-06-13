package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String COMPANY_DETAIL_KEY = "company";

    ImageView ivLogo;
    TextView tvName;
    TextView tvPrice;
    TextView tvDetails;

    ViewPager vpStocks;
    SwipeAdaptor adaptor;

    Company company = DataProvider.generateCompany(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Layout ID values
        ivLogo = findViewById (R.id.companyLogo);
        tvName = findViewById(R.id.companyName);
        tvPrice = findViewById(R.id.companyPrice);
        tvDetails = findViewById(R.id.companyDescription);
        vpStocks = (ViewPager)findViewById(R.id.stockData);
        adaptor = new SwipeAdaptor(this);
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

//        // Set Screen Flipper Values
//        int[] images = stock.getStock_images();

    }
}
