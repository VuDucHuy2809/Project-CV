package com.example.csv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DataAdapter extends ArrayAdapter<ItemData> {
    Context context;
    List<ItemData> items;
    public DataAdapter(Context context, int layoutTobeInflated, List<ItemData> items) {
        super(context, R.layout.list_item, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.list_item,null);
        TextView tvHoTen = (TextView)row.findViewById(R.id.txtHoTen);
        TextView tvMaSo = (TextView)row.findViewById(R.id.txtMaSo);
        TextView tvNgayGio = (TextView)row.findViewById(R.id.txtNgayGio);
        tvHoTen.setText(items.get(position).holot + " " + items.get(position).ten);
        tvMaSo.setText(items.get(position).maso);
        tvNgayGio.setText(items.get(position).ngay + " - " + items.get(position).gio);
        return row;
    }

}
