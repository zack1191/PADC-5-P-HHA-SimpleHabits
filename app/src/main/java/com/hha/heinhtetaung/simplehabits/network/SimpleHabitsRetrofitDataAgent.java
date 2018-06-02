package com.hha.heinhtetaung.simplehabits.network;

import com.google.gson.Gson;
import com.hha.heinhtetaung.simplehabits.event.LoadNetworkErrorEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadSimpleHabitEvent;
import com.hha.heinhtetaung.simplehabits.network.response.GetCategoriesResponse;
import com.hha.heinhtetaung.simplehabits.network.response.GetCurrentProgramResponse;
import com.hha.heinhtetaung.simplehabits.network.response.GetTopicResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 5/23/2018.
 */

public class SimpleHabitsRetrofitDataAgent implements SimpleHabitsDataAgent {

    private static SimpleHabitsRetrofitDataAgent sObjInstance;

    private SimpleHabitsApi simpleApi;

    public static SimpleHabitsRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new SimpleHabitsRetrofitDataAgent();
        }
        return sObjInstance;
    }

    public SimpleHabitsRetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder() //2

                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();
        simpleApi = retrofit.create(SimpleHabitsApi.class);

    }

    @Override
    public void loadTopic() {
        final Call<GetTopicResponse> getTopicResponseCall = simpleApi.getTopics(1, "b002c7e1a528b7cb460933fc2875e916");
        getTopicResponseCall.enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse getTopicResponse = response.body();
                if (getTopicResponse != null) {
                    LoadSimpleHabitEvent.LoadTopicEvent event = new LoadSimpleHabitEvent.LoadTopicEvent(getTopicResponse.getTopics());
                    EventBus.getDefault().post(event);

                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                LoadNetworkErrorEvent errorEvent = new LoadNetworkErrorEvent();
                EventBus.getDefault().post(errorEvent);
            }
        });

    }

    @Override
    public void loadCurrentProgram() {
        final Call<GetCurrentProgramResponse> getCurrentProgramResponse = simpleApi.getCurrentProgram(1, "b002c7e1a528b7cb460933fc2875e916");
        getCurrentProgramResponse.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse getCurrentProgramResponse = response.body();
                if (getCurrentProgramResponse != null) {
                    LoadSimpleHabitEvent.LoadCurrentProgramEvent event = new LoadSimpleHabitEvent.LoadCurrentProgramEvent(getCurrentProgramResponse.getCurrentProgram());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                LoadNetworkErrorEvent errorEvent = new LoadNetworkErrorEvent();
                EventBus.getDefault().post(errorEvent);
            }
        });

    }

    @Override
    public void loadCategoriesProgram() {
        final Call<GetCategoriesResponse> getCategoriesResponse = simpleApi.getCategories(1, "b002c7e1a528b7cb460933fc2875e916");
        getCategoriesResponse.enqueue(new Callback<GetCategoriesResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesResponse> call, Response<GetCategoriesResponse> response) {
                GetCategoriesResponse getCategoriesResponse1 = response.body();
                if (getCategoriesResponse1 != null) {
                    LoadSimpleHabitEvent.LoadCategoriesEvent event = new LoadSimpleHabitEvent.LoadCategoriesEvent(getCategoriesResponse1.getCategoriesPrograms());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetCategoriesResponse> call, Throwable t) {
                LoadNetworkErrorEvent errorEvent = new LoadNetworkErrorEvent();
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
