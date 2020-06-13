package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.content.Intent;
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

    public static final String COMPANY_DETAIL_KEY = "company";

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

        //---------------------------------------------------------
        Company company = DataProvider.generateCompany(1);
        //=====================
        Intent intent = new Intent(MainActivity.this, Company_Details.class);
        intent.putExtra(COMPANY_DETAIL_KEY, company);
        startActivity(intent);


    }
}
