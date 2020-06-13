package com.example.tradecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ListCompaniesAdapter extends ArrayAdapter<Company> {

    private static class ViewHolder{

        public ImageView companyimage;
        public TextView  company_text;

    }


    public ListCompaniesAdapter(Context context, ArrayList<Company> aCompany) {
        super(context,0, aCompany);
    }

    //Translates a particular 'Country' given a position
    //into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Countries country = getItem(position);


        final Company company = getItem(position);

        //Check if an existing view is being reused, otherwise inflate the view

        ListCompaniesAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ListCompaniesAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.company_list_layout,parent,false);
            viewHolder.companyimage = (ImageView)convertView.findViewById(R.id.countryflag);
            viewHolder.company_text = (TextView)convertView.findViewById(R.id.countrytext);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ListCompaniesAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.company_text.setText(company.getName());
        int imageID=company.getLogo();
        viewHolder.companyimage.setImageResource(imageID);


        return convertView;
    }


}
