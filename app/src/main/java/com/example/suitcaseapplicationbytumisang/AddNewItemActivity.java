package com.example.suitcaseapplicationbytumisang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.suitcaseapplicationbytumisang.statusbar.StatusBarUtil;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class AddNewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        StatusBarUtil.setStatusBarColor(this, getColor(R.color.primaryColor));

        //Custom toolbar
        MaterialToolbar materialToolbar = findViewById(R.id.addItemToolBar);
        materialToolbar.setTitle("New item");
        materialToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        //SetNavigationIcon(arrow back) ActionListener
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}