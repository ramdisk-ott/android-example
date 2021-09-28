package com.ramdisk.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ramdisk.login.city.CityActivity;
import com.ramdisk.login.country.CountryActivity;
import com.ramdisk.login.store.StoreActivity;
import com.ramdisk.login.uom.UOMActivity;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step-1 get refereance of edittext
        Button button = findViewById(R.id.loginButton);
        Button recyclerViewButton = findViewById(R.id.recyclerViewButton);
        //step-2 add listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to go to login screen use below code
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        recyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.uomButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UOMActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.cityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.storeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });
    }
}