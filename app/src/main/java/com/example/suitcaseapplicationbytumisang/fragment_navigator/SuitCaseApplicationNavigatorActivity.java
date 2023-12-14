package com.example.suitcaseapplicationbytumisang.fragment_navigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.suitcaseapplicationbytumisang.R;
import com.example.suitcaseapplicationbytumisang.adapter.SuitCaseApplicationNavigatorActivityAdapter;
import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;
import com.google.android.material.appbar.MaterialToolbar;
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

        //Customer toolbar related
        MaterialToolbar materialToolbar = findViewById(R.id.mainApplicationToolBar);
        setSupportActionBar(materialToolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager2 = findViewById(R.id.mainApplicationNavigationViewPager2);

        SuitCaseApplicationNavigatorActivityAdapter fragmentNavigatorActivityAdapter = new
                SuitCaseApplicationNavigatorActivityAdapter(getSupportFragmentManager(), getLifecycle());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_memu, menu);
        return true;
    }
}