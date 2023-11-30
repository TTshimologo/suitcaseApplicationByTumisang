package com.example.suitcaseapplicationbytumisang.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.suitcaseapplicationbytumisang.LoginFragment;
import com.example.suitcaseapplicationbytumisang.SignUpFragment;

public class LoginAndSignUpViewPagerAdapter extends FragmentStateAdapter {

    /*Here I created LoginAndSignUpViewPagerAdapter class that extends the FragmentStateAdapter to
    * work with the viewPaper2 component in Android to manage and provide fragments for a swipeable
    * UI, specifically for a login and sign-up screen */

    //FragmentManager object is responsible for handling the fragments.
    //Lifecycle object is responsible for managing the lifecycle for the fragments.
    public LoginAndSignUpViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new LoginFragment();
        }
        return new SignUpFragment();

    }

    @Override
    public int getItemCount() {
        return 2; //Total number of fragments
    }
}
