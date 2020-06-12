package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare the ListView and the Adapter
        ListView tradeview;
        CompaniesAdapter companyAdapter;
        ArrayList<Countries> aCompany;

        tradeview = (ListView) findViewById(R.id.tradeview);
        ArrayList<Countries> aBooks = new ArrayList<Countries>();


        aBooks = CompanyProvider.generateData();
        companyAdapter = new CompaniesAdapter(this, aBooks);

        //Set that adapter to the listview
        tradeview.setAdapter(companyAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

//        SliderView sliderView = findViewById(R.id.imageSlider);
//
//        StockSliderAdapter adapter = new StockSliderAdapter(this);
//
//        sliderView.setSliderAdapter(adapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();

        }


    }
