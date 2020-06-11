package com.example.tradecheck;

import android.widget.ArrayAdapter;

public class CompanyAdapter extends ArrayAdapter<Company> {
    public BookAdapter(Context context, ArrayList<Book> aBooks){
        super(context, 0, aBooks);
    }
}
