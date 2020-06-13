package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.view.View;

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
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare the ListView, CardVi and the Adapter
        ListView tradeview;
        CompaniesAdapter companyAdapter;

        //Declare Array List
        ArrayList<Countries> aCompany;
        //Assign the id of tradeview to the trade view.
        tradeview = (ListView) findViewById(R.id.tradeview);
        ArrayList<Countries> aCountry = new ArrayList<Countries>();
        aCountry = CompanyProvider.generateData();
        companyAdapter = new CompaniesAdapter(this, aCountry);

        //Set that adapter to the listview
        tradeview.setAdapter(companyAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);


        ///ATTEMPT TO GET IT WORKING but idk what does the error mesage means
//        tradeview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent companiesIntent= new Intent(getBaseContext(), CompaniesActivity.class);
//                companiesIntent.putExtra("CategoryMessage", "This message come from categories");
//                startActivity(companiesIntent);
//            }
//        });


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

        //UNCOMMENT THAT and use the intent above.

//Intent to the Companies Activity
    public void showCompaniesActivity(View v){
    Intent companiesIntent= new Intent(this, CompaniesActivity.class);
    startActivity(companiesIntent);

    }

    
}
