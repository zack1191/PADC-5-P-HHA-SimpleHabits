package com.hha.heinhtetaung.simplehabits;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.adapters.BottomBarAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.TabAdapter;
import com.hha.heinhtetaung.simplehabits.fragments.OnthegoFragment;
import com.hha.heinhtetaung.simplehabits.fragments.SeriesFragment;
import com.hha.heinhtetaung.simplehabits.fragments.TeachersFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tl_tablayout)
    TabLayout tbTabLayout;

    @BindView(R.id.vp_viewpager)
    ViewPager vpViewPager;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private TabAdapter mTabAdapter;

    private BottomBarAdapter mBottomBarAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);


        mTabAdapter = new TabAdapter(getSupportFragmentManager());
        mBottomBarAdapter = new BottomBarAdapter(getSupportFragmentManager());
        vpViewPager.setAdapter(mTabAdapter);
        tbTabLayout.setupWithViewPager(vpViewPager);
        vpViewPager.setOffscreenPageLimit(mTabAdapter.getCount());

        //add tab
        mTabAdapter.addTab("ON THE GO", new OnthegoFragment());
        mTabAdapter.addTab("SERIES", new SeriesFragment());
        mTabAdapter.addTab("TEACHERS", new TeachersFragment());


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.it_meditate:
                        toolbar.setTitle("Meditate");
                        Toast.makeText(MainActivity.this, "Meditate", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.it_person:
                        toolbar.setTitle("Me");
                        Toast.makeText(MainActivity.this, "Me", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.it_more:
                        toolbar.setTitle("More");
                        Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



}
