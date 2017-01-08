package com.jaaaelu.gzw.threadpoolexecutordemo.net;

import com.jaaaelu.gzw.threadpoolexecutordemo.model.Girls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2016/12/13.
 */

public interface ApiManager {

    @GET("data/福利/{count}/{page}")
    Call<Girls> getGirlsImage(@Path("count") String count, @Path("page") String page);

}
