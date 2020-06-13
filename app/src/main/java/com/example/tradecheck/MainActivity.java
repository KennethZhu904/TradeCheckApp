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
    //ViewFlipper vfStocks;

    ViewPager vpStocks;
    SwipeAdaptor adaptor;

    Company company = DataProvider.generateCompany(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign Layout ID values
        ivLogo = findViewById (R.id.companyLogo);
        tvName = findViewById(R.id.companyName);
        tvPrice = findViewById(R.id.companyPrice);
        tvDetails = findViewById(R.id.companyDescription);
        //vfStocks = findViewById(R.id.stockData);
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
//
//
//        // Loop over the image view
//        // https://abhiandroid.com/ui/viewflipper
//        for (int image : images) {
//            //Create the object of the image view
//            ImageView imageview = new ImageView(this);
//            imageview.setImageResource(image); //Set the image in the image Viewer
//            vfStocks.addView(imageview); //Add this created image viewer in the flipper
//        }
//
//        //Direct from tutorial -- Ill implement in adapter later on
//        // Declare in and out animations and load them using AnimationUtils class
//        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
//        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
//        // set the animation type's to ViewFlipper
//        vfStocks.setInAnimation(in);
//        vfStocks.setOutAnimation(out);
//        // set interval time for flipping between views
//        vfStocks.setFlipInterval(3000);
//        // set auto start for flipping between views
//        vfStocks.setAutoStart(true);
        //------------------------------------------------------------------------------
    }
}
