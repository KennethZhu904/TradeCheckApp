package com.example.tradecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CompanyDetailAdapter extends ArrayAdapter<Company> {


    private static class ViewHolder{

        public ImageView ivLogo;
        public TextView tvName;
        public TextView tvPrice;
        public TextView tvDetails;

    }


    public CompanyDetailAdapter(Context context, ArrayList<Company> aCompany){

        super(context, 0, aCompany);

    }

    //translates a particular Company given a position
    //into a relevant row within an AdapterView

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        final Company company = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_company__details,parent,false);
            viewHolder.ivLogo = (ImageView)convertView.findViewById(R.id.companyLogo);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.companyName);
            viewHolder.tvPrice = (TextView)convertView.findViewById(R.id.companyPrice);
            viewHolder.tvDetails = (TextView)convertView.findViewById(R.id.companyDescription);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object

        // Set the text values
        viewHolder.tvName.setText(company.getName());
        viewHolder.tvDetails.setText(company.getDescription());

        // Set company logo
        viewHolder.ivLogo.setImageResource(company.getLogo());

        // Get stock data
        StockInfo stock = company.getStock();

//        viewHolder.tvTitle.setText(book.getTitle());
//        viewHolder.tvAuthor.setText(book.getAuthor());
//
//        int resID = book.getCover();
//
//        viewHolder.ivCover.setImageResource(resID);

        //viewHolder.ivCover.setImageResource(R.drawable.b002);


        return convertView;
    }
}
