package com.example.john_keels_it_project.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.john_keels_it_project.views.fragments.AddStudentFragment;
import com.example.john_keels_it_project.views.fragments.StudentFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int ITEM_SIZE = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //This function returns the Fragments based on the position index
        if (position == 0) {
            return AddStudentFragment.newInstance();
        }
        return StudentFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return ITEM_SIZE;
    }
}