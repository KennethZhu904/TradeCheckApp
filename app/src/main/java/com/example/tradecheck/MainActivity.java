package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.view.View;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
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


    //Declare the ListView and the Adapter
    ListView tradeview;
    CompaniesAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Declare Array List
        ArrayList<Countries> aCompany;
        //Assign the id of tradeview to the trade view.
        tradeview = (ListView) findViewById(R.id.tradeview);
        ArrayList<Countries> aCountry = new ArrayList<Countries>();
        aCountry = CompanyProvider.generateData();
        countryAdapter = new CompaniesAdapter(this, aCountry);

        //Set that adapter to the listview
        tradeview.setAdapter(countryAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupCompanySelectedListener();


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



//    View.OnClickListener australiaclickhandler = new View.OnClickListener() {
//        public void onClick(View view) {
//            Intent companyactivity = new Intent(getBaseContext(), CompaniesActivity.class);
//            companyactivity.putExtra("MessageFromMainActivity", "australia");
//            startActivity(companyactivity);
//        }
//    };
//
//    View.OnClickListener nzclickhandler = new View.OnClickListener() {
//        public void onClick(View view) {
//            Intent companyactivity = new Intent(getBaseContext(), CompaniesActivity.class);
//            companyactivity.putExtra("MessageFromMainActivity", "newzealand");
//            startActivity(companyactivity);
//        }
//    };
//
//    View.OnClickListener singaporelickhandler = new View.OnClickListener() {
//        public void onClick(View view) {
//            Intent companyactivity = new Intent(getBaseContext(), CompaniesActivity.class);
//            companyactivity.putExtra("MessageFromMainActivity", "singapore");
//            startActivity(companyactivity);
//        }
//    };
//
//    View.OnClickListener usclickhandler = new View.OnClickListener() {
//        public void onClick(View view) {
//            Intent companyactivity = new Intent(getBaseContext(),CompaniesActivity.class);
//            companyactivity.putExtra("MessageFromMainActivity", "unitedstates");
//            startActivity(companyactivity);
//        }
//    };


    public void setupCompanySelectedListener(){
        tradeview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CompaniesActivity.class);

                if (position == 0) {
                    intent.putExtra("company", "australia");
                } else if (position == 1) {
                    intent.putExtra("company", "newzealand");
                } else if (position == 2) {
                    intent.putExtra("company", "singapore");
                } else if (position == 3) {
                    intent.putExtra("company", "unitedstates");
                }
                startActivity(intent);
            }
        });

    }


// Currently using it.

//Intent to the Companies Activity
//    public void showCompaniesActivity(View v){
//    Intent companiesIntent= new Intent(this, CompaniesActivity.class);
//    startActivity(companiesIntent);
//
//    }

    }

