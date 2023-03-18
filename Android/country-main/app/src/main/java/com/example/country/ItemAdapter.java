package com.example.country;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    Context context;
    private List<Country> countryList;
    public ItemAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }
    public void setData(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Country country = countryList.get(position);
        if(country == null)
            return;
        ((TextView) holder.view.findViewById(R.id.countryname)).setText(country.getCountryName());
        ((TextView) holder.view.findViewById(R.id.countrycode)).setText(country.getCountryCode() + " - ");
        ((TextView) holder.view.findViewById(R.id.currencycode)).setText(country.getCurrencyCode());
        String url = "https://img.geonames.org/flags/x/"+country.getCountryCode().toLowerCase()+".gif";
        Picasso.get().load(url).into((ImageView) holder.view.findViewById(R.id.imageView));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Country c = countryList.get(position);
                Intent intent = new Intent(view.getContext(),DetailCountry.class);
                intent.putExtra("Detail",c);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(countryList != null)
            return countryList.size();
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
        }

    }
}
