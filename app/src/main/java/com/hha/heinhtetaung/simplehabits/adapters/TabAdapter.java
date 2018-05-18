package com.hha.heinhtetaung.simplehabits.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/17/2018.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<String> mTabTitles;
    private List<Fragment> mTabFragments;

    public TabAdapter(FragmentManager fm) {
        super(fm);
        mTabFragments = new ArrayList<>();
        mTabTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mTabFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    public void addTab(String title, Fragment fragment) {
        mTabTitles.add(title);
        mTabFragments.add(fragment);
        notifyDataSetChanged();
    }
}
