package com.ramdisk.login.city;

import android.os.Bundle;
import android.util.Log;

import com.ramdisk.login.R;
import com.ramdisk.login.RetrofitUtil;
import com.ramdisk.login.uom.UOM;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;

public class CityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        List<UOM> uoms = new ArrayList<>();
        Log.d("CityActivity", "onCreate: ");

       /* UOM uom = new UOM();
        uom.setAbbreviation("Piece");

        uoms.add(uom);

        uom = new UOM();
        uom.setAbbreviation("KiloGram");
        uoms.add(uom);*/
        RetrofitUtil.context = getApplicationContext();
        RetrofitUtil.getInstance();

        Call<List<Cities>> call = RetrofitUtil.networkService.cities();
        call.enqueue(new Callback<List<Cities>>() {
            @Override
            public void onResponse(Call<List<Cities>> call, retrofit2.Response<List<Cities>> response) {
                if (response.body() != null) {
                    CityAdapter countryAdapter = new CityAdapter(response.body());
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(dividerItemDecoration);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(countryAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Cities>> call, Throwable t) {
            }
        });

    }
}
