package com.example.suitcaseapplicationbytumisang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //Custom toolbar
        MaterialToolbar materialToolbar = findViewById(R.id.editItemToolBar);
        materialToolbar.setTitle("Edit");
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