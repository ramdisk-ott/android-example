package com.ramdisk.login.uom;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramdisk.login.R;

import java.util.List;

public class UOMAdapter extends RecyclerView.Adapter<UOMAdapter.CountryHolder> {
    private List<UOM> uoms;

    public UOMAdapter(List<UOM> uoms) {
        this.uoms = uoms;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.uom_row, parent, false);
        return new CountryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        UOM country = uoms.get(position);
        holder.abbreviation.setText(country.getAbbreviation());

    }

    @Override
    public int getItemCount() {
        return uoms.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        public TextView abbreviation;

        public CountryHolder(View view) {
            super(view);
            abbreviation = view.findViewById(R.id.abbreviation);

        }
    }

}
