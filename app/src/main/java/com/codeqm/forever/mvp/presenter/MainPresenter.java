package com.codeqm.forever.mvp.presenter;


import com.codeqm.forever.bean.TestBean;
import com.codeqm.forever.http.ApiCallback;
import com.codeqm.forever.mvp.model.BaseModel;
import com.codeqm.forever.mvp.view.MainView;

/**
 * Created by chenqm on 2016/12/15.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava() {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataByRetrofitRxjava(),
                new ApiCallback<BaseModel<TestBean>>() {
                    @Override
                    public void onSuccess(BaseModel<TestBean> model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

}
