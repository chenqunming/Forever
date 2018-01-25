package com.codeqm.forever.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.codeqm.forever.http.ApiStores;
import com.codeqm.forever.http.AppClient;
import com.codeqm.forever.util.LogUtil;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by chenqm on 2016/12/15.
 */

public class BaseActivity extends AppCompatActivity {

//    @BindView(R.id.left_btn)
//    ImageView leftBtn;
//    @BindView(R.id.right_btn)
//    ImageView rightBtn;
//    @BindView(R.id.centet_title)
//    TextView centetTitle;
    protected Activity mActivity;


    protected ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);
    protected CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mActivity = this;
    }


    @Override
    protected void onDestroy() {
        onUnsubscribe();
        super.onDestroy();
    }

//    @OnClick(R.id.left_btn)
//    public void onClick() {
//        finish();
//    }
//
//    public void setRightBtn(int resId, View.OnClickListener listener) {
//        rightBtn.setVisibility(View.VISIBLE);
//        rightBtn.setImageResource(resId);
//        rightBtn.setOnClickListener(listener);
//    }
//
//    public void setBack() {
//        leftBtn.setVisibility(View.VISIBLE);
//    }
//
//    public void setCentetTitle(String title) {
//        if (!TextUtils.isEmpty(title)) {
//            centetTitle.setText(title);
//        }
//    }



    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    public void onUnsubscribe() {
        LogUtil.d("onUnsubscribe");
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions())
            mCompositeSubscription.unsubscribe();
    }

}
