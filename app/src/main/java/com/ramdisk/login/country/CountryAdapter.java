package com.ramdisk.login.country;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramdisk.login.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {
    private List<Country> countryList;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_row, parent, false);
        return new CountryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = countryList.get(position);
        holder.name.setText(country.getName());
        holder.populationTV.setText(country.getPopulation() + "");
        holder.capitalTV.setText(country.getCapital());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        public TextView name, populationTV, capitalTV;

        public CountryHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            populationTV = view.findViewById(R.id.populationTV);
            capitalTV = view.findViewById(R.id.capitalTV);
        }
    }

}
