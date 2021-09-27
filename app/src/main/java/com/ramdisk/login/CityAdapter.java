package com.ramdisk.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramdisk.login.uom.UOM;
import com.ramdisk.login.uom.UOMAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.Holder> {
public List<Cities> cities;

    public CityAdapter(List<Cities> body) {
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cities, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Cities country = cities.get(position);
        holder.id.setText(country.getId());
        holder.name.setText(country.getName());
        holder.state.setText(country.getState());
        holder.pincode.setText(country.getPincode());

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView id,name,state,pincode;

        public Holder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            state=itemView.findViewById(R.id.state);
            pincode=itemView.findViewById(R.id.pincode);





        }
    }
}
