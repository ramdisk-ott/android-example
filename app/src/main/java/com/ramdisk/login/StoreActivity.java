package com.ramdisk.login;

import android.os.Bundle;
import android.util.Log;

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
import retrofit2.Response;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
        List<UOM> uoms = new ArrayList<>();
        Log.d("storeActivity", "onCreate: ");
        RetrofitUtil.context = getApplicationContext();
        RetrofitUtil.getInstance();

        Call<List<Store>> call = RetrofitUtil.networkService.store();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                if (response.body() != null) {
                    StoreAdapter countryAdapter = new StoreAdapter(response.body());
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(dividerItemDecoration);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(countryAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
            }
        });

    }
}






