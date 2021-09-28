package com.ramdisk.login.uom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ramdisk.login.R;
import com.ramdisk.login.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class UOMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uomactivity);
        List<UOM> uoms = new ArrayList<>();

       /* UOM uom = new UOM();
        uom.setAbbreviation("Piece");

        uoms.add(uom);

        uom = new UOM();
        uom.setAbbreviation("KiloGram");
        uoms.add(uom);*/
        RetrofitUtil.context = getApplicationContext();
        RetrofitUtil.getInstance();
        //
        Call<List<UOM>> call = RetrofitUtil.networkService.uoms();
        call.enqueue(new Callback<List<UOM>>() {
            @Override
            public void onResponse(Call<List<UOM>> call, retrofit2.Response<List<UOM>> response) {
                if (response.body() != null) {
                    UOMAdapter countryAdapter = new UOMAdapter(response.body());
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(dividerItemDecoration);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(countryAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<UOM>> call, Throwable t) {
            }
        });

    }
}