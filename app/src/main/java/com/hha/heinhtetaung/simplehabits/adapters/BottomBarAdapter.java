package com.hha.heinhtetaung.simplehabits.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/17/2018.
 */

public class BottomBarAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public BottomBarAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragments(Fragment fragment) {
        fragments.add(fragment);
        notifyDataSetChanged();
    }
}
