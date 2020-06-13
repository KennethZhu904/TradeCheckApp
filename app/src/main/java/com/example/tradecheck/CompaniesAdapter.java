package com.example.tradecheck;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompaniesAdapter extends ArrayAdapter<Countries> {

    static class ViewHolder{

        public ImageView countryflag;
        public TextView  countrytext;


    }


    public CompaniesAdapter(Context context, ArrayList<Countries> aCountry){

        super(context, 0, aCountry);

    }

    //Translates a particular 'Country' given a position
    //into a relevant row ithin an AdapterView

    //get the data item for this position
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final Countries country = getItem(position);

        //ArrayList<Company> companyList = DataProvider.generateCompanies(DataProvider.AustraliaId);

        //Check if an existing view is being reused, otherwise inflate the view

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_layout_list,parent,false);
            viewHolder.countryflag = (ImageView)convertView.findViewById(R.id.countryflag);
            viewHolder.countrytext = (TextView)convertView.findViewById(R.id.countrytext);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.countrytext.setText(country.getName());
        int imageID=country.getFlagFileName();
        viewHolder.countryflag.setImageResource(imageID);


        return convertView;
    }







}
