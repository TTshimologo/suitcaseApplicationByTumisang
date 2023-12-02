package com.example.suitcaseapplicationbytumisang.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.suitcaseapplicationbytumisang.HomeScreenFragment;
import com.example.suitcaseapplicationbytumisang.PurchasedScreenFragment;

public class SuitCaseApplicationNavigatorActivityAdaptor extends FragmentStateAdapter {

    public SuitCaseApplicationNavigatorActivityAdaptor(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PurchasedScreenFragment();
            case 0:
            default:
                return new HomeScreenFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
