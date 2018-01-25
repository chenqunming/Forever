package com.codeqm.forever.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by chenqm on 2016/12/15.
 */

public class BaseFragment extends Fragment {

//    @BindView(R.id.left_btn)
//    ImageView leftBtn;
//    @BindView(R.id.right_btn)
//    ImageView rightBtn;
//    @BindView(R.id.centet_title)
//    TextView centetTitle;
    protected Activity mActivity = null;
    protected View mContentView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
//            mContext = getContext();
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

//    protected void setRightBtn(View.OnClickListener listener) {
//        rightBtn.setVisibility(View.VISIBLE);
//        rightBtn.setOnClickListener(listener);
//    }
//    protected void setRightBtn(int resId, View.OnClickListener listener) {
//        rightBtn.setVisibility(View.VISIBLE);
//        rightBtn.setImageResource(resId);
//        rightBtn.setOnClickListener(listener);
//    }
//
//    protected void setBack() {
//        leftBtn.setVisibility(View.VISIBLE);
//    }
//
//    protected void setCentetTitle(String title) {
//        if (!TextUtils.isEmpty(title)) {
//            centetTitle.setText(title);
//        }
//    }


    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }


    private CompositeSubscription mCompositeSubscription;

    public void onUnsubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
//        if (mCompositeSubscription == null) {
        mCompositeSubscription = new CompositeSubscription();
//        }
        mCompositeSubscription.add(subscription);
    }
}
