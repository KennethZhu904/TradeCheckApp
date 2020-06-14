package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
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
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static final String COMPANY_DETAIL_KEY = "company";

    ImageView ivLogo;
    TextView tvName;
    TextView tvPrice;
    TextView tvDetails;

    ViewPager vpStocks;
    SwipeAdaptor adaptor;

    Company company = DataProvider.generateCompany(12);


    //Declare the ListView and the Adapter
    ListView tradeview;
    CompaniesAdapter countryAdapter;
//    CompaniesAdapter companyAdapter;

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

        /////That i did
//        ArrayList<Company> theCompany = new ArrayList<Company>();
//        companyAdapter = new CompaniesAdapter(this, aCountry);
//
//        setupStockSelectedListener();


        }

//        // Get stock data
//        StockInfo stock = company.getStock();



//    public void setupStockSelectedListener(){
//        tradeview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Launch the detail view passing company as an extra
//                Intent intent = new Intent(MainActivity.this, Company_Details.class);
//
//                intent.putExtra(COMPANY_DETAIL_KEY, companyAdapter.getItem(position));
//                startActivity(intent);
//            }
//        });
//    }

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

