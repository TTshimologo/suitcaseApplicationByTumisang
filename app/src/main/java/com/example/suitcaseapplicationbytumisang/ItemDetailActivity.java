package com.example.suitcaseapplicationbytumisang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.primaryColor));
    }
}