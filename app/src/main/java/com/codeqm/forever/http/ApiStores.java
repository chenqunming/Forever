package com.codeqm.forever.http;


import com.codeqm.forever.bean.TestBean;
import com.codeqm.forever.mvp.model.BaseModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 *
 */
public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://api.pubmi.guoshikai.com/";

    //加载天气
    @GET("public/total")
    Observable<BaseModel<TestBean>> loadDataByRetrofitRxjava();
}
