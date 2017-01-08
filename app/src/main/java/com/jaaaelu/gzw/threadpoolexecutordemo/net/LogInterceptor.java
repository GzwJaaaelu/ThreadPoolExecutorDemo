package com.jaaaelu.gzw.threadpoolexecutordemo.net;


import com.jaaaelu.gzw.threadpoolexecutordemo.util.LoggerUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response = chain.proceed(chain.request());
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        long t1 = System.nanoTime();
        LoggerUtil.printGeneralLog(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        long t2 = System.nanoTime();
        LoggerUtil.printGeneralLog(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        LoggerUtil.printGeneralLog("NetWork" + "response body:" + content);
//        Gson gson = new Gson();
//        BaseModel baseModel = gson.fromJson(content, BaseModel.class);
//        if (baseModel != null) {
//            if (baseModel.getCode() != 0) {
//                EventBus.getDefault().post(baseModel.getMsg());
//            }
//        }
        if (response.body() != null) {
            ResponseBody body = ResponseBody.create(mediaType, content);
            return response.newBuilder().body(body).build();
        }
        return response;
    }
}