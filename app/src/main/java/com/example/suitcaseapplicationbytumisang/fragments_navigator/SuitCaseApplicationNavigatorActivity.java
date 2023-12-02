package com.example.suitcaseapplicationbytumisang.fragments_navigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.suitcaseapplicationbytumisang.HomeScreenFragment;
import com.example.suitcaseapplicationbytumisang.LoginFragment;
import com.example.suitcaseapplicationbytumisang.PurchasedScreenFragment;
import com.example.suitcaseapplicationbytumisang.R;
import com.example.suitcaseapplicationbytumisang.adapter.SuitCaseApplicationNavigatorActivityAdaptor;
import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SuitCaseApplicationNavigatorActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_case_application_navigator);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.colorPrimaryDark));

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager2 = findViewById(R.id.mainApplicationNavigationViewPager2);

        SuitCaseApplicationNavigatorActivityAdaptor fragmentNavigatorActivityAdapter = new
                SuitCaseApplicationNavigatorActivityAdaptor(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(fragmentNavigatorActivityAdapter);

        //Link bottomNavigationView with viewPager 2
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.homeID) {
                    viewPager2.setCurrentItem(0, true);
                    return true;
                } else if (itemId == R.id.purchasedID) {
                    viewPager2.setCurrentItem(1, true);
                    return true;
                } else {
                    return false;
                }
            }
        });

        // Add a listener to handle page changes in the ViewPager2
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // Update the selected item in the BottomNavigationView when the page changes
                bottomNavigationView.setSelectedItemId(getBottomNavigationItemId(position));
            }
        });

    }

    // Helper method to map ViewPager2 position to BottomNavigationView item ID
    private int getBottomNavigationItemId(int position) {
        switch (position) {
            case 0:
                return R.id.homeID;
            case 1:
                return R.id.purchasedID;
            default:
                return 0;
        }
    }

}