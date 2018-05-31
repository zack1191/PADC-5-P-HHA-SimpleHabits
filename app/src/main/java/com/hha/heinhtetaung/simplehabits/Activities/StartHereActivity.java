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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.SessionsAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.SessionsVO;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadSimpleHabitEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 5/27/2018.
 */

public class StartHereActivity extends AppCompatActivity {


    @BindView(R.id.tv_download_disc)
    TextView tvDownLoadDisc;

    @BindView(R.id.tb_tool_bar)
    Toolbar toolbar;

    @BindView(R.id.rv_sessions_recycler)
    RecyclerView rvSessions;

    private SessionsAdapter mSessionsAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, StartHereActivity.class);
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

        SimpleModel.getsObjInstance().loadDatas();

        CurrentProgramVO mCurrent = new CurrentProgramVO();
        bindData(mCurrent);

    }
    public void bindData(CurrentProgramVO current){
        tvDownLoadDisc.setText(current.getDescription());
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

   @Subscribe(threadMode = ThreadMode.MAIN)
   public void onDataLoaded(LoadReadyDataEvent event){
       mSessionsAdapter.setNewData(event.getShareParentVO());
  }
}
