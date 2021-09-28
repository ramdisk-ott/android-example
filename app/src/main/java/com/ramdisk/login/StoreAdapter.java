package com.ramdisk.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.Holder> {
    public List<Store> store;

    public StoreAdapter(List<Store> stores) {
        this.store = stores;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.store, parent, false);
        return new Holder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Store country = store.get(position);
        holder.name.setText(country.getName());
        holder.mobile.setText(country.getMobile());
        holder.gst.setText(country.getGst()+"");

    }
    @Override
    public int getItemCount() {return store.size();
    }
    public class Holder extends RecyclerView.ViewHolder {
            public TextView mobile;
            public TextView name;
            public TextView gst;

            public Holder(@NonNull View itemView) {
                super(itemView);
                mobile = itemView.findViewById(R.id.mobile);
                name= itemView.findViewById(R.id.name);
                gst = itemView.findViewById(R.id.gst);




            }

    }
}