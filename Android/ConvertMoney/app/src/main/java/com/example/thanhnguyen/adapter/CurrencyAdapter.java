package com.example.thanhnguyen.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanhnguyen.currencyconversion.R;
import com.example.thanhnguyen.model.Currency;

import java.util.List;


public class CurrencyAdapter extends ArrayAdapter<Currency> {

    Activity context;
    int resource;
    List<Currency> objects;
    public CurrencyAdapter(Activity context, int resource, List<Currency> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);
        Currency currency = this.objects.get(position);
        ImageView imgFlag = (ImageView) item.findViewById(R.id.imgFlag);
        TextView txtType= (TextView) item.findViewById(R.id.txtType);
        TextView txtRate = (TextView) item.findViewById(R.id.txtRate);

        imgFlag.setImageBitmap(currency.getBitmap());
        txtType.setText(currency.getType());
        txtRate.setText(currency.getPrice());

        return item;
    }
}
