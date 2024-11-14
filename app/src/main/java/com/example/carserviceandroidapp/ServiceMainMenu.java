package com.example.carserviceandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ServiceMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main_menu);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ServiceAccount()).commit();

    }

    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment selectedFragment=null;

                   switch(item.getItemId()) {
                       case R.id.account:
                           selectedFragment = new ServiceAccount();
                           break;
                       case R.id.appointment:
                           selectedFragment = new Provider_Appointment();
                           break;
                       case R.id.history:
                           selectedFragment = new ServiceHistory();
                           break;
                   }

                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                   return true;
                }
            };
    
}