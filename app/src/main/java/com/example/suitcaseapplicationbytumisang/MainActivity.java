package com.example.suitcaseapplicationbytumisang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.suitcaseapplicationbytumisang.fragment_navigator.LoginAndSignUpScreenNavigatorActivity;
import com.example.suitcaseapplicationbytumisang.fragment_navigator.SuitCaseApplicationNavigatorActivity;
import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.primaryColor));

        progressBar = findViewById(R.id.SHOW_PROGRESS);

        /* Creating a Handler object for a task that is do be executed later after the application
        launches and in this case the task is for the application to switch from the current
        MainActivity to the LoginActivity
        after a postDelayed time of 3 seconds*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,
                        LoginAndSignUpScreenNavigatorActivity.class);
                startActivity(intent);
                // Transition effect
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                // Show the progress bar while loading
                progressBar.setVisibility(View.VISIBLE);
                finish(); // Closes MainActivity when LoginActivity has been started
            }
        }, 3000);
    }


}