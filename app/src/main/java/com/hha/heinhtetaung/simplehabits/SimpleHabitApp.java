package com.hha.heinhtetaung.simplehabits;

import android.app.Application;

import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;

/**
 * Created by E5 on 5/24/2018.
 */

public class SimpleHabitApp extends Application {
    public static final String LOG_TAG = "SIMPLE_HABIT";
    public static final String CURRENT_PROGRAM = "CurrentProgram";
    public static final String CATEGORIES_PROGRAM = "CategoriesProgram";

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
