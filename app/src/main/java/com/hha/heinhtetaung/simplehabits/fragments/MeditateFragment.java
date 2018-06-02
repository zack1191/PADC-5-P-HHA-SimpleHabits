package com.hha.heinhtetaung.simplehabits.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.BottomBarAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.TabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/17/2018.
 */

public class MeditateFragment extends Fragment {
    private TabAdapter mTabAdapter;
    private BottomBarAdapter mBottomBarAdapter;

    @BindView(R.id.vp_viewpager)
    ViewPager vpMeditate;

    @BindView(R.id.tl_meditate)
    TabLayout tlTabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);
        ButterKnife.bind(this, view);
        mTabAdapter = new TabAdapter(getFragmentManager());
        mBottomBarAdapter = new BottomBarAdapter(getFragmentManager());
        vpMeditate.setAdapter(mTabAdapter);
        tlTabLayout.setupWithViewPager(vpMeditate);
        vpMeditate.setOffscreenPageLimit(mTabAdapter.getCount());

        //add tab
        mTabAdapter.addTab("ON THE GO", new OnthegoFragment());
        mTabAdapter.addTab("SERIES", new SeriesFragment());
        mTabAdapter.addTab("TEACHERS", new TeachersFragment());


        return view;
    }
}
