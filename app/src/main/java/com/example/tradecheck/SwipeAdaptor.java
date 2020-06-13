package com.example.tradecheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SwipeAdaptor extends PagerAdapter {
    private int[] image_resources = {R.drawable.day_001, R.drawable.month_001, R.drawable.years_001};
    String [] image_timeFrames = {"Day", "Month", "Year"};
    private Context context;
    private LayoutInflater layoutInflater;

    // constructor only context
    public SwipeAdaptor(Context ctx){
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.stock_slider, container, false);
         ImageView imageView = (ImageView)item_view.findViewById(R.id.stockImage);
         TextView textView = (TextView)item_view.findViewById(R.id.stockTime);

        //Set the resources
        imageView.setImageResource(image_resources[position]);
        textView.setText(image_timeFrames[position]);

        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object); //Relative Layout
    }
}
