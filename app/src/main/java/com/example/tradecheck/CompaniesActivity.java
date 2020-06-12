package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class CompaniesActivity extends AppCompatActivity {

   ListView companies_list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);

        //ATTEMPT TO GET IT WORKING THIS MORNIGN but error message came up.

//        Intent thisIntent=getIntent();
//        String message=thisIntent.getStringExtra("CategoryMessage");
//        Toast.makeText(this,message, Toast.LENGTH_LONG).show();

        //Link the id to the activity_companies list
        companies_list=(ListView) findViewById(R.id.companyview);




    }
}