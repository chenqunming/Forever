package com.codeqm.forever.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.codeqm.forever.R;
import com.codeqm.forever.bean.TestBean;
import com.codeqm.forever.mvp.model.BaseModel;
import com.codeqm.forever.mvp.presenter.MainPresenter;
import com.codeqm.forever.mvp.view.MainView;
import com.codeqm.forever.ui.base.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }


    @Override
    public void getDataSuccess(BaseModel<TestBean> model) {
        //接口成功回调
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        showLongToast("网络不给力");

    }


    private void dataSuccess(BaseModel<TestBean> model) {
        TestBean testbaen = model.getData();
        showLongToast(testbaen.getMoney());
    }

    @OnClick(R.id.textView)
    public void onClick() {
        mvpPresenter.loadDataByRetrofitRxjava();
    }
}
