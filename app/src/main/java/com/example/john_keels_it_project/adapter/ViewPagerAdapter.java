package com.example.john_keels_it_project.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.john_keels_it_project.views.AddStudentFragment;
import com.example.john_keels_it_project.views.StudentFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int CARD_ITEM_SIZE = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return AddStudentFragment.newInstance();
        }
        return StudentFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return CARD_ITEM_SIZE;
    }
}