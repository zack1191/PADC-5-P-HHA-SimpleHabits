package com.hha.heinhtetaung.simplehabits;

import android.app.Application;

import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;

/**
 * Created by E5 on 5/24/2018.
 */

public class SimpleHabitApp extends Application {
    public static final String LOG_TAG = "SIMPLE_HABIT";

    public static final String PROGRAM_ID = "ProgramId";
    public static final String VIEW_TYPE = "viewType";
    public static final String CURRENT_PROGRAM = "currentProgram";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_PROGRAM_ID = "categoryProgramId";


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
