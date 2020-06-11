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

    public CompaniesAdapter(Context context, ArrayList<Countries> aCountry){

        super(context, 0, aCountry);

    }

}
