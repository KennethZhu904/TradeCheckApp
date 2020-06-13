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

        // Use the company to populate the data into the format
        Intent thisIntent = getIntent();
        // Use the book to populate the data into our views
        Company company = (Company) thisIntent.getSerializableExtra(MainActivity.COMPANY_DETAIL_KEY); //xoxoxoxoxoxoxoxox
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
        vfStocks.addView();



        // https://abhiandroid.com/ui/viewflipper
        for(int i = 0; i < images.length; i++){
            //Create the object of the image view
            ImageView imageview = new ImageView(this);
            imageview.setImageResource(images[i]); //Set the image in the image Viewer
            vfStocks.addView(imageview); //Add this created image viewer in the flipper
        }



        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());

        //String mDrawableName = book.getCover();
        //int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        int resID = book.getCover();
        ivBookCover.setImageResource(resID);


    }
}