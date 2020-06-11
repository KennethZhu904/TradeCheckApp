package com.example.tradecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          String[] countries= CompanyProvider.getCountries();
        List<String> countriesNames=new ArrayList(Arrays.asList(countries));

        ArrayAdapter<String> countriesAdapter=new ArrayAdapter<String>(this,R.layout.category_layout_list,countriesNames);
        ListView listView= findViewById(R.id.tradeview);

    }
}