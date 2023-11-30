package com.example.suitcaseapplicationbytumisang.fragments_navigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.suitcaseapplicationbytumisang.LoginFragment;
import com.example.suitcaseapplicationbytumisang.R;
import com.example.suitcaseapplicationbytumisang.SignUpFragment;
import com.example.suitcaseapplicationbytumisang.adapter.LoginAndSignUpViewPagerAdapter;
import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;

import me.relex.circleindicator.CircleIndicator3;

public class LoginAndSignUpScreenNavigatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_sign_up_screen_navigator);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.colorPrimaryDark));

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        CircleIndicator3 circleIndicator3 = findViewById(R.id.indicator);

        LoginAndSignUpViewPagerAdapter viewPagerAdapter = new
                LoginAndSignUpViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(viewPagerAdapter);

        //Link CircleIndicator3 with ViewPager2
        circleIndicator3.setViewPager(viewPager2);

        //Setting the ViewPager2.OnPageChangeCallback to handle page changes
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }
}