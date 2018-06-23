package com.hha.heinhtetaung.simplehabits.mvp.presenters;

import com.hha.heinhtetaung.simplehabits.mvp.views.BaseView;

/**
 * Created by E5 on 6/21/2018.
 */
public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onCreate() {

    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onDestroy() {

    }


}
