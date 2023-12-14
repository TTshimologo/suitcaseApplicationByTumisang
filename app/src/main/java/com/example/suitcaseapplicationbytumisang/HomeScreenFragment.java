package com.example.suitcaseapplicationbytumisang;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class HomeScreenFragment extends Fragment {

    private ActionMode mActionMode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View homeScreen = inflater.inflate(R.layout.fragment_home_screen, container, false);

        /* Using ColorStateList resource file to define different colors for different states for the
        floatingBTN icon*/
        FloatingActionButton fab = homeScreen.findViewById(R.id.addNewItemFloatingBTN);
        ColorStateList colorStateList = ContextCompat.getColorStateList(requireContext(),
                R.color.fab_icon_tint);
        fab.setImageTintList(colorStateList);

        //floatingBTN ActionLister
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent for the AddNewItemActivity The starting the activity
                Intent intent = new Intent(getContext(), AddNewItemActivity.class);
                startActivity(intent);

            }
        });

        return homeScreen;
    }

}