package com.hha.heinhtetaung.simplehabits.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.SimpleHabitApp;
import com.hha.heinhtetaung.simplehabits.adapters.SessionsAdapter;


import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.SessionsVO;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadSimpleHabitEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/27/2018.
 */

public class StartHereActivity extends AppCompatActivity {


    @BindView(R.id.tv_download_disc)
    TextView tvDownLoadDisc;

    @BindView(R.id.tv_current_title)
    TextView tvCurrentTitle;

    @BindView(R.id.tb_tool_bar)
    Toolbar toolbar;

    @BindView(R.id.rv_sessions_recycler)
    RecyclerView rvSessions;


    private SessionsAdapter mSessionsAdapter;
    private CurrentProgramVO currentProgramVO;
    private ProgramVO programVO;
    private List<CategoriesProgramVO> categoriesProgramVO;

    public static Intent newIntentCurrent(Context context) {
        Intent intent = new Intent(context, StartHereActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    public static Intent newIntentCategories(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, StartHereActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CATEGORY);
        intent.putExtra(SimpleHabitApp.CATEGORY_ID, categoryId);
        intent.putExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID, categoryProgramId);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_here);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
        }

        mSessionsAdapter = new SessionsAdapter(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessions.setLayoutManager(layoutManager);
        rvSessions.setAdapter(mSessionsAdapter);


        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramVO currentProgram = SimpleModel.getsObjInstance().getCurrentProgram();
            mSessionsAdapter.setNewData(currentProgram.getSessions());
            tvCurrentTitle.setText(currentProgram.getTitle());
            tvDownLoadDisc.setText(currentProgram.getDescription());
        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);

            ProgramVO categoryProgram = SimpleModel.getsObjInstance().getProgram(categoryId, categoryProgramId);
            mSessionsAdapter.setNewData(categoryProgram.getSessions());
            tvCurrentTitle.setText(categoryProgram.getTitle());
            tvDownLoadDisc.setText(categoryProgram.getDescription());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_start_here, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }


}
