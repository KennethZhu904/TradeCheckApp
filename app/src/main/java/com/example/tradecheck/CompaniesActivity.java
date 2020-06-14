package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.GONE;
import static com.example.tradecheck.DataProvider.AustraliaId;
import static com.example.tradecheck.DataProvider.NZId;
import static com.example.tradecheck.DataProvider.SingaporeId;
import static com.example.tradecheck.DataProvider.USId;

public class CompaniesActivity extends AppCompatActivity {
    public static final String COMPANY_DETAIL_KEY   = "company";

    ListView companies_list;
    TextView Companyname;
    ImageView Companypicture ;
    CompanyDetailAdapter detailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //ATTEMPT TO GET IT WORKING THIS MORNIGN but error message came up.

//        Intent thisIntent=getIntent();
//        String message=thisIntent.getStringExtra("CategoryMessage");
//        Toast.makeText(this,message, Toast.LENGTH_LONG).show();


        // Receiving Intent is created so that it receives the data from the main screen.
        Intent intent = getIntent();
        String categorytoopen = intent.getStringExtra("company");


        //Declare the adapter.
        ListCompaniesAdapter listcompanyadapter;


        // Set content view
        setContentView(R.layout.activity_companies);  //CHeck if it is the layout file we are looking at or jus the variable part.

        // Create ListView objects to associate with XML views
        companies_list = (ListView) findViewById(R.id.companyview);
        Companyname = (TextView) findViewById(R.id.companytext); //Similarly go for the coutnry text.
        Companypicture=(ImageView) findViewById(R.id.companyimage); // Check in regards to whether it clashes with the country list

        ArrayList<Company> aCompany = new ArrayList<Company>();

    //Set conditions so the system knows where to fetch the data.
         if (categorytoopen.equals("australia")) {
            aCompany = DataProvider.generateCompanies(AustraliaId);

        } else if (categorytoopen.equals("newzealand")) {
            aCompany = DataProvider.generateCompanies(NZId);
        } else if (categorytoopen.equals("singapore")) {
             aCompany = DataProvider.generateCompanies(SingaporeId);
         } else if (categorytoopen.equals("unitedstates")){
             aCompany = DataProvider.generateCompanies(USId);
        }


        listcompanyadapter = new ListCompaniesAdapter(this, aCompany);

        //Set that adapter to the listview
        companies_list.setAdapter(listcompanyadapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        detailAdapter = new CompanyDetailAdapter(this, aCompany);

        setupStockSelectedListener();
    }

    public void setupStockSelectedListener() {
        companies_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(CompaniesActivity.this, Company_Details.class);
                intent.putExtra(COMPANY_DETAIL_KEY, detailAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}