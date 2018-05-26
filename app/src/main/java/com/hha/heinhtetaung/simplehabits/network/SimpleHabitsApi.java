package com.hha.heinhtetaung.simplehabits.network;

import android.telecom.Call;

import com.hha.heinhtetaung.simplehabits.network.response.GetCategoriesResponse;
import com.hha.heinhtetaung.simplehabits.network.response.GetCurrentProgramResponse;
import com.hha.heinhtetaung.simplehabits.network.response.GetTopicResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 5/23/2018.
 */

public interface SimpleHabitsApi {

    @FormUrlEncoded
    @POST("getTopics.php")
    retrofit2.Call<GetTopicResponse> getTopics(@Field("page") int page,
                                               @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    retrofit2.Call<GetCurrentProgramResponse> getCurrentProgram(@Field("page") int page,
                                                                @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    retrofit2.Call<GetCategoriesResponse> getCategories(@Field("page") int page,
                                                        @Field("access_token") String accessToken);
}
