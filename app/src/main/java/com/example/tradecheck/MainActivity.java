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
//        ListView tradeview;
//        CompaniesAdapter companyAdapter;
//        ArrayList<Countries> aCompany;
//
//        tradeview = (ListView) findViewById(R.id.tradeview);
//        ArrayList<Countries> aBooks = new ArrayList<Countries>();
//
//
//        aBooks = CompanyProvider.generateData();
//        companyAdapter = new CompaniesAdapter(this, aBooks);
//
//        //Set that adapter to the listview
//        tradeview.setAdapter(companyAdapter);
//
//        LinearLayoutManager lm = new LinearLayoutManager(this);

        SliderView sliderView = findViewById(R.id.imageSlider);

        StockSliderAdapter adapter = new StockSliderAdapter(this);


        adapter.addItem(new SliderItem("Day", "https://media.wired.com/photos/5b8999943667562d3024c321/master/w_2560%2Cc_limit/trash2-01.jpg" ));
        adapter.addItem(new SliderItem("Month", "https://i.kym-cdn.com/entries/icons/mobile/000/013/564/doge.jpg"));
        adapter.addItem(new SliderItem("Year", "https://i.guim.co.uk/img/static/sys-images/Guardian/Pix/pictures/2013/12/19/1387462292398/c447b512-ea0b-423e-b5f4-7f66b0db44bb-620x372.jpeg?width=300&quality=45&auto=format&fit=max&dpr=2&s=b1875610cc7ed39c7865f42563ba75cd"));
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


        LinearLayoutManager lm = new LinearLayoutManager(this);
        }


    }
