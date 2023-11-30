package com.example.suitcaseapplicationbytumisang.fragments_navigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.suitcaseapplicationbytumisang.HomeScreenFragment;
import com.example.suitcaseapplicationbytumisang.LoginFragment;
import com.example.suitcaseapplicationbytumisang.PurchasedScreenFragment;
import com.example.suitcaseapplicationbytumisang.R;
import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SuitCaseApplicationNavigatorActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_case_application_navigator);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.colorPrimaryDark));

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.container);

        //Default screen to open after login
        loadFragment(new HomeScreenFragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemID = item.getItemId();

                if (itemID == R.id.homeID) {

                    loadFragment(new HomeScreenFragment());

                } else if (itemID == R.id.purchasedID) {

                    loadFragment(new PurchasedScreenFragment());

                }

                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}