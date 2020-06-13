package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.smarteist.autoimageslider.SliderView;

public class Company_Details extends AppCompatActivity {

    private ImageView ivLogo;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvDetails;
    private ViewFlipper vfStocks;
    //private SliderView svStocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__details);

        //Assign Layout ID values
        ivLogo = (ImageView) findViewById (R.id.companyLogo);
        tvName = (TextView) findViewById(R.id.companyName);
        tvPrice = (TextView) findViewById(R.id.companyPrice);
        tvDetails = (TextView) findViewById(R.id.companyDescription);
        vfStocks =(ViewFlipper) findViewById(R.id.stockData);
        //svStocks = (SliderView) findViewById(R.id.imageSlider);
    }
}