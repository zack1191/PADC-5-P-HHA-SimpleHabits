package com.hha.heinhtetaung.simplehabits;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.activities.DetailProgramActivity;
import com.hha.heinhtetaung.simplehabits.adapters.BottomBarAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.TabAdapter;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.fragments.MeFragment;
import com.hha.heinhtetaung.simplehabits.fragments.MeditateFragment;
import com.hha.heinhtetaung.simplehabits.fragments.MoreFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;


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
        MenuItem item = bottomNavigationView.getMenu().findItem(R.id.it_meditate);
        if (item.isCheckable() || item.isChecked()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new MeditateFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.it_meditate:
                        toolbar.setTitle("Meditate");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new MeditateFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Meditate", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.it_person:
                        toolbar.setTitle("Me");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new MeFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Me", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.it_more:
                        toolbar.setTitle("More");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_container, new MoreFragment())
                                .commit();
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


//    @Override
//    public void onTapCategories(String categoryId, String categoryProgramId) {
//        Intent intent = DetailProgramActivity.newIntentCategories(getApplicationContext(), categoryId, categoryProgramId);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onTapStartHere() {
//        Intent intent = DetailProgramActivity.newIntentCurrent(getApplicationContext());
//        startActivity(intent);
//    }
}
