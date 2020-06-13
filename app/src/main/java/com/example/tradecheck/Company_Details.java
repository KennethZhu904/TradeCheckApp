package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        // Use the company to populate the data into the format
        Intent thisIntent = getIntent();
        // Use the book to populate the data into our views
        //Company company = (Company) thisIntent.getSerializableExtra(MainActivity.COMPANY_DETAIL_KEY);
        Company company = DataProvider.generateCompany(1);
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
        tvPrice.setText(stock.getPrice());

        // Set Screen Flipper Values
        int[] images = stock.getStock_images();


        // Loop over the image view
        // https://abhiandroid.com/ui/viewflipper
        for (int image : images) {
            //Create the object of the image view
            ImageView imageview = new ImageView(this);
            imageview.setImageResource(image); //Set the image in the image Viewer
            vfStocks.addView(imageview); //Add this created image viewer in the flipper
        }

        //Direct from tutorial -- Ill implement in adapter later on
        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        vfStocks.setInAnimation(in);
        vfStocks.setOutAnimation(out);
        // set interval time for flipping between views
        vfStocks.setFlipInterval(3000);
        // set auto start for flipping between views
        vfStocks.setAutoStart(true);
        //------------------------------------------------------------------------------
    }
}