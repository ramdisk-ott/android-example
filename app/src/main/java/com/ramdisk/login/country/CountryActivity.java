package com.ramdisk.login.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ramdisk.login.R;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        List<Country> countries = new ArrayList<>();

        Country country = new Country();
        country.setName("India");
        country.setPopulation(10000);
        country.setCapital("Delhi");
        countries.add(country);

        country = new Country();
        country.setName("Pakistan");
        country.setPopulation(5000);
        country.setCapital("Karachi");
        countries.add(country);


        //
        CountryAdapter countryAdapter = new CountryAdapter(countries);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(countryAdapter);

    }
}